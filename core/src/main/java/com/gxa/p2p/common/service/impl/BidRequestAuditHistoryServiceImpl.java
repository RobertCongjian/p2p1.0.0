package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.business.domain.BidRequestAuditHistory;
import com.gxa.p2p.business.mapper.BidRequestAuditHistoryMapper;
import com.gxa.p2p.business.mapper.BidRequestMapper;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.BidRequestAuditHistoryService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.DateUtil;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BidRequestAuditHistoryServiceImpl implements BidRequestAuditHistoryService {

    @Autowired
    private BidRequestAuditHistoryMapper bidRequestAuditHistoryMapper;

    @Autowired
    private BidRequestMapper bidRequestMapper;

    @Autowired
    private IUserInfoService iUserInfoService;



    @Override
    public int insertInfo(BidRequestAuditHistory bidRequestAuditHistory) {

        BidRequest bidRequest = bidRequestMapper.queryById(bidRequestAuditHistory.getBidRequestId());
        Date auditTime = new Date();
        Date applyTime = bidRequest.getApplyTime();
        Long auditor_id = UserContext.getLoginInfo().getId();
        Long applier_id = bidRequest.getCreateUser().getId();
        int auditType = BidRequestAuditHistory.PUBLISH_AUDIT;

        bidRequestAuditHistory.setAuditTime(auditTime);
        bidRequestAuditHistory.setApplyTime(applyTime);
        bidRequestAuditHistory.setAuditorId(auditor_id);
        bidRequestAuditHistory.setApplierId(applier_id);
        bidRequestAuditHistory.setAuditType(auditType);
        int row1 = bidRequestAuditHistoryMapper.insertInfo(bidRequestAuditHistory);

        BidRequest bidRequestupdate = new BidRequest();
        if(bidRequestAuditHistory.getState()==BidRequestAuditHistory.STATE_AUDIT){
            if(bidRequest.getBidRequestState()==0){//待发布进入招标中状态
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_BIDDING);

            }
            if(bidRequest.getBidRequestState()==1){//满标1审：满标后进入满标一审（待审）；
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_1);

            }
            if(bidRequest.getBidRequestState()==4){//满标2审：通过满标一审，进入满标二审（待审）
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_2);
            }
            if(bidRequest.getBidRequestState()==5){//还款中：通过满标二审，进入还款状态
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_PAYING_BACK);
            }

            bidRequestupdate.setPublishTime(bidRequestAuditHistory.getAuditTime());

            bidRequestupdate.setDisableDate(DateUtil.getBidrequestMaturity(auditTime, bidRequest.getDisableDays()));
        }

        if(bidRequestAuditHistory.getState()==BidRequestAuditHistory.STATE_REJECT){
            if(bidRequest.getBidRequestState()==0){//初审拒绝状态：发标前审核失败；
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_PUBLISH_REFUSE);

            }

            if(bidRequest.getBidRequestState()==4||bidRequest.getBidRequestState()==5){
                bidRequestupdate.setBidRequestState(SysConstant.BIDREQUEST_STATE_REJECTED);

            }
            //审核未通过移除状态
            Userinfo userinfo = iUserInfoService.getUserInfoById(applier_id);

            userinfo.removeState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);

            iUserInfoService.updateItem(userinfo,applier_id);
        }
        bidRequestupdate.setNote(bidRequestAuditHistory.getRemark());




        int row2 =  bidRequestMapper.updateItem(bidRequestupdate,bidRequestAuditHistory.getBidRequestId());


        return row1+row2;
    }
}
