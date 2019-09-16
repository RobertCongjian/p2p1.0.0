package com.gxa.p2p.common.controller;


import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.BitStatesUtils;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.SysConstant;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private BidRequestService bidRequestService;


    /**
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public JSONResult bindPhone(String phoneNumber, String verifyCode) {
        JSONResult json = new JSONResult();

        try {
            iUserInfoService.bindPhone(phoneNumber, verifyCode);
            json.setSuccess(true);
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
            System.err.println("出现异常！" + e.getMessage());
        }
        return json;
    }

    /**
     * 绑定邮件
     */
    @RequestMapping("bindEmail")
    public String bingEmail(String code, Model model) {
        System.out.println(code);
        try {
            iUserInfoService.bindEmail(code);
            model.addAttribute("success", true);
            System.err.println("绑定成功");
        } catch (Exception e) {
            model.addAttribute("success", false);
            System.err.println(e.getMessage());
            model.addAttribute("msg", e.getMessage());
        }
        return "checkmail_result";
    }


    /**
     * 进入借款信息审核页面
     */
    @RequestMapping("borrow")
    public String toBorrow(Model model) {
        Long id = UserContext.getLoginInfo().getId();
        Userinfo userinfo = iUserInfoService.getUserInfoById(id);
        if (userinfo.getEducationbackgroundId() == 0 || userinfo.getHouseconditionId() == 0 ||
                userinfo.getIncomegradeId() == 0 || userinfo.getKidcountId() == 0 || userinfo.getMarriageId() == 0) {
            userinfo.removeState(BitStatesUtils.OP_USER_INFO);
        }


        Account account = iAccountService.getAccountById(id);
        model.addAttribute("userinfo", userinfo);
        model.addAttribute("account", account);
        model.addAttribute("creditBorrowScore", SysConstant.CREDIT_BORROW_SCORE);

        return "borrow";
    }


    @RequestMapping("/index")
    public String toMain(Model model) {

        model.addAttribute("bidRequests", bidRequestService.queryPassAuditing());

        return "main";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("logininfo");
        session.invalidate();
        return "redirect:/";

    }


}
