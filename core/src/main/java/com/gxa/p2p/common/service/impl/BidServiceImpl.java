package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.business.domain.Bid;
import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.business.mapper.BidMapper;
import com.gxa.p2p.business.mapper.BidRequestMapper;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.service.BidService;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidMapper bidMapper;

    @Autowired
    private BidRequestMapper bidRequestMapper;

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public int invest(Long bidRequestId, BigDecimal amount) {

        Long userId = UserContext.getLoginInfo().getId();
        BidRequest bidRequestOld = bidRequestMapper.queryById(bidRequestId);

        Bid bid = new Bid();
        bid.setBidUserId(userId);
        bid.setActualRate(bidRequestOld.getCurrentRate());
        bid.setAvailableAmount(amount);
        bid.setBidTime(new Date());
        bid.setBidRequestId(bidRequestId);

        int row1 = bidMapper.insertBid(bid);


        BidRequest bidRequest = new BidRequest();
        bidRequest.setCurrentSum(amount);
        bidRequest.setBidCount(1);
        int row2 = bidRequestMapper.updateItem(bidRequest, bidRequestId);
        if(row2==1){
            BidRequest bidRequest1 = bidRequestMapper.queryById(bidRequestId);
            if(bidRequest1.getCurrentSum().compareTo(bidRequest1.getBidRequestAmount())==0){
                BidRequest changeState = new BidRequest();
                changeState.setBidRequestState(SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_1);
                bidRequestMapper.updateItem(changeState,bidRequestId);
            }
        }

        accountMapper.updateByUserId(userId,amount);

        return row1+row2;
    }
}
