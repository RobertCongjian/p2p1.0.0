package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.service.ILoginInfoService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginInfoController {

    @Autowired
    private ILoginInfoService iLoginInfoService;

    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean checkUsername(String username) {
        int count  = iLoginInfoService.checkUsername(username);
        return count <= 0;
    }

    @RequestMapping("register")
    @ResponseBody
    public JSONResult register(String username, String password) {

        JSONResult json = new JSONResult();
        try {
            iLoginInfoService.register(username, password);
            json.setSuccess(true);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }


    @RequestMapping("login")
    @ResponseBody
    public JSONResult login(String username, String password, HttpSession session){
        JSONResult json = new JSONResult();
        try{
            LoginInfo loginInfo = iLoginInfoService.login(username,password,LoginInfo.USER_WEB);
            json.setMsg(LoginInfo.SUCCESS_MSG);
            json.setSuccess(true);
            session.setAttribute("logininfo", loginInfo);
        }catch (RuntimeException re){
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }
}

