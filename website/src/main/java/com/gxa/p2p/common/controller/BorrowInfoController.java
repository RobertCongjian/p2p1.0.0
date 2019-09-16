package com.gxa.p2p.common.controller;

import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class BorrowInfoController {

    @Autowired
    private BidRequestService bidRequestService;
    @Autowired
    private IAccountService accountService;

    @RequestMapping("borrow_info")
    public String getBorrowInfo(Long id, Model model){

        long userId = UserContext.getLoginInfo().getId();

        Map<String,Object> map = bidRequestService.queryInfoById(id);
        BidRequest bidRequest = (BidRequest) map.get("bidRequest");
        model.addAttribute("bidRequest",bidRequest);
        model.addAttribute("userInfo", map.get("userInfo"));
        model.addAttribute("account",accountService.getAccountById(userId));
        if(bidRequest.getCreateUser().getId()==userId){
            model.addAttribute("self", true);
        }else {
            model.addAttribute("self", false);
        }


        return "borrow_info";
    }
}
