package com.gxa.p2p.controller;


import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserListController {


    @Autowired
    private ILoginInfoService iLoginInfoService;

    /**
     * 用户信息列表
     *
     * @param loginInfoQueryObject
     * @param model
     * @return
     */
    @RequestMapping("user_list")
    public String userList(LoginInfoQueryObject loginInfoQueryObject, Model model) {

        model.addAttribute("pageResultSet",iLoginInfoService.queryForPage(loginInfoQueryObject));
        return "user/list";
    }


}
