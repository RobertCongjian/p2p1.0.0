package com.gxa.p2p.common.controller;


import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.service.IUserInfoService;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;


    @RequestMapping("userInfo")
    public String toUserInfo(Model model, HttpSession session) {

        Map<String, Object> map;
        map = iUserInfoService.getInfo(session);

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        Userinfo userinfo = (Userinfo) map.get("userinfo");
        System.err.println(userinfo.toString());

        for (Systemdictionaryitem systemdictionaryitem : userinfo.getSystemdictionaryitems()) {
            if (systemdictionaryitem.getParentid() == 1) {
                userinfo.setIncomegradeItem(systemdictionaryitem);
                System.err.println(systemdictionaryitem.toString());
            }
            if (systemdictionaryitem.getParentid() == 2) {
                userinfo.setEducationbackgroundItem(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 3) {
                userinfo.setMarriageItem(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 4) {
                userinfo.setKidcountItem(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 5) {
                userinfo.setHouseconditionItem(systemdictionaryitem);
            }

        }
        model.addAttribute("userinfo", userinfo);


        List<Systemdictionaryitem> systemdictionaryitems = (List<Systemdictionaryitem>) map.get("systemdictionaryitem");
        for (Systemdictionaryitem systemdictionaryitem : systemdictionaryitems) {
            if (systemdictionaryitem.getParentid() == 1) {
                list1.add(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 2) {

                list2.add(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 3) {

                list3.add(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 4) {

                list4.add(systemdictionaryitem);
            }
            if (systemdictionaryitem.getParentid() == 5) {

                list5.add(systemdictionaryitem);
            }
        }
        model.addAttribute("incomeGrades", list1);
        model.addAttribute("educationBackgrounds", list2);
        model.addAttribute("marriages", list3);
        model.addAttribute("kidCounts", list4);
        model.addAttribute("houseConditions", list5);
        return "userInfo";
    }

    @RequestMapping("userInfo2")
    public String toUserInfo2(Model model){

        model.addAttribute("userinfo", iUserInfoService.getUserInfoById(UserContext.getLoginInfo().getId()));
        model.addAttribute("incomeGrades", iUserInfoService.selectItemBysn("incomeGrade"));
        model.addAttribute("educationBackgrounds",iUserInfoService.selectItemBysn("educationBackground") );
        model.addAttribute("marriages",iUserInfoService.selectItemBysn("marriage") );
        model.addAttribute("kidCounts",iUserInfoService.selectItemBysn("kidCount") );
        model.addAttribute("houseConditions",iUserInfoService.selectItemBysn("houseCondition") );

        return "userInfo";

    }




    @RequestMapping("userInfo_save")
    @ResponseBody
    public JSONResult userInfoSave(Userinfo userinfo,HttpSession session) {
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("logininfo");
        Userinfo userinfo1 = iUserInfoService.getUserInfoById(loginInfo.getId());
        userinfo.setBitstate(userinfo1.getBitstate());
        JSONResult json = new JSONResult();
        try {
            iUserInfoService.updateItem(userinfo,loginInfo.getId());
            json.setSuccess(true);
        } catch (RuntimeException re) {
            json.setSuccess(false);
            json.setMsg(re.getMessage());
        }
        return json;
    }


}
