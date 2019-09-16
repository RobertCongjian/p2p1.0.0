package com.gxa.p2p.common.controller;


import com.gxa.p2p.common.query.BidRequestQueryObject;

import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.service.BidService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;


@Controller
public class InvestController {


    @Autowired
    private BidRequestService bidRequestService;

    @Autowired
    private BidService bidService;

    @RequestMapping("/invest")
    public String toInvest(){


        return "invest";
    }

    @RequestMapping("/invest_list")

    public String getBidRequestInfo(Model model,BidRequestQueryObject bidRequestQueryObject){

        model.addAttribute("pageResult",bidRequestService.queryForPageWithState(bidRequestQueryObject));

        return "invest_list";
    }


    @RequestMapping("borrow_bid")
    @ResponseBody
    public JSONResult borrowBid(Long bidRequestId, BigDecimal amount){

        JSONResult jsonResult = new JSONResult();
        int row = bidService.invest(bidRequestId,amount);
        if(row == 2){
            jsonResult.setSuccess(true);
        }else {
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }




}
