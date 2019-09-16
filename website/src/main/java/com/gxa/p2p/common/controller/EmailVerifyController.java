package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.service.IMailService;
import com.gxa.p2p.common.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 发送邮件相关服务
 *
 */
@Controller
public class EmailVerifyController {

    @Autowired
    private IMailService iEmailVerifyService;

    @RequestMapping("sendEmail")
    @ResponseBody
    public JSONResult sendEmail(String email){

        JSONResult json = new JSONResult();
        try {
            iEmailVerifyService.sendVerifyEmail(email);
            json.setSuccess(true);

        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json ;
    }
}

