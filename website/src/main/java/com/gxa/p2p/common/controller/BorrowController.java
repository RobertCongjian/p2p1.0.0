package com.gxa.p2p.common.controller;


import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.service.impl.UserServiceImpl;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {

    @Autowired
    private BidRequestService bidRequestService;
    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("/borrowInfo")
    public String toBorrowApplyPage(Model model){

        long id = UserContext.getLoginInfo().getId();
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        model.addAttribute("minBidAmount", SysConstant.SMALLEST_BID_AMOUNT);
        model.addAttribute("minBidRequestAmount", SysConstant.SMALLEST_BIDREQUEST_AMOUNT);

        return "borrow_apply";
    }


    @RequestMapping("borrow_apply")
    public String borrow_apply(BidRequest bidRequest){

        System.err.println(bidRequest);
        Long id = UserContext.getLoginInfo().getId();
        Userinfo userinfo = iUserInfoService.getUserInfoById(id);
        if(!userinfo.getIsApply()){
            bidRequestService.insertBidRequest(bidRequest);
            userinfo.addState(BitStatesUtils.OP_HAS_BIDREQUEST_PROCESS);
            iUserInfoService.updateItem(userinfo, id);

            return "borrow_apply_success";
        }else {

            return "borrow_apply_result";
        }

    }


}
