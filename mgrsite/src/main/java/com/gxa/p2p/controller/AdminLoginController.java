package com.gxa.p2p.controller;


import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("/login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpSession session, HttpServletRequest request) {
        JSONResult json = new JSONResult();

        LoginInfo loginInfo = iLoginInfoService.login(username, password, LoginInfo.USER_MGR, request);
        if (loginInfo != null) {
            json.setMsg(LoginInfo.SUCCESS_MSG);
            json.setSuccess(true);
            session.setAttribute("logininfo", loginInfo);
        } else {
            json.setSuccess(false);
            json.setMsg("登录失败，密码或账户错误！");
        }

        return json;
    }


}
