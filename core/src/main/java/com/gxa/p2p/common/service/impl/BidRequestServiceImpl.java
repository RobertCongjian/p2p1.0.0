package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.business.domain.BidRequestAuditHistory;
import com.gxa.p2p.business.mapper.BidRequestAuditHistoryMapper;
import com.gxa.p2p.business.mapper.BidRequestMapper;
import com.gxa.p2p.business.util.CalculatetUtil;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.query.BidRequestQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.BidRequestAuditHistoryService;
import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bidRequestService")
public class BidRequestServiceImpl implements BidRequestService {

    @Autowired
    private BidRequestMapper bidRequestMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private BidRequestAuditHistoryMapper bidRequestAuditHistoryMapper;


    @Override
    public int insertBidRequest(BidRequest bidRequest) {
        bidRequest.setApplyTime(new Date());
        bidRequest.setBidRequestType(0);
        bidRequest.setBidRequestState(0);
        bidRequest.setBidCount(0);

        bidRequest.setCurrentSum(new BigDecimal(0));
        bidRequest.setCreateUser(UserContext.getLoginInfo());


        BigDecimal totalRewardAmount = CalculatetUtil.calTotalInterest(bidRequest.getReturnType(), bidRequest.getBidRequestAmount(), bidRequest.getCurrentRate(), bidRequest.getMonthes2Return());

        bidRequest.setTotalRewardAmount(totalRewardAmount);


        System.err.println(bidRequest.toString());


        return bidRequestMapper.insertBidRequest(bidRequest);
    }

    @Override
    public PageResultSet queryForPage(BidRequestQueryObject bidRequestQueryObject,int id) {
        int count = bidRequestMapper.queryForCount(id);
        System.err.println("===================================>"+count);

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<BidRequest> list =bidRequestMapper.queryForPage(bidRequestQueryObject,id);

            for(BidRequest bidRequest:list){
                System.err.println(bidRequest.toString());
                System.out.println();
            }

            if(list.size()==0){

                bidRequestQueryObject.setCurrentPage(bidRequestQueryObject.getCurrentPage()-1);
                list = bidRequestMapper.queryForPage(bidRequestQueryObject,id);
                pageResultSet = new PageResultSet(
                        list,
                        count,
                        bidRequestQueryObject.getCurrentPage(),
                        bidRequestQueryObject.getPageSize()
                );
            }else {
                pageResultSet = new PageResultSet(
                        list,
                        count,
                        bidRequestQueryObject.getCurrentPage(),
                        bidRequestQueryObject.getPageSize());
            }



        } else {
            pageResultSet = PageResultSet.empty(bidRequestQueryObject.getPageSize());
        }

        return pageResultSet;

    }

    @Override
    public Map<String, Object> queryInfoById(Long id) {
        Map<String,Object> map = new HashMap<>();
        BidRequest bidRequest = bidRequestMapper.queryById(id);


        map.put("bidRequest", bidRequest);
        map.put("audits", bidRequestAuditHistoryMapper.listAuditHistorayByBidRequest(id));
        map.put("userInfo",userinfoMapper.selectByPrimaryKey(bidRequest.getCreateUser().getId()));

        return map;

    }

    @Override
    public List<BidRequest> queryPassAuditing() {
        return bidRequestMapper.queryPassAuditing();
    }



    @Override
    public PageResultSet queryForPageWithState(BidRequestQueryObject bidRequestQueryObject) {

        int count = bidRequestMapper.queryForCountWithState(bidRequestQueryObject);

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<BidRequest> list =bidRequestMapper.queryForPageWithState(bidRequestQueryObject);


            pageResultSet = new PageResultSet(
                    list,
                    count,
                    bidRequestQueryObject.getCurrentPage(),
                    bidRequestQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(bidRequestQueryObject.getPageSize());
        }

        return pageResultSet;

    }

}
