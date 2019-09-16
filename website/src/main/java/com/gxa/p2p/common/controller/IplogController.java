package com.gxa.p2p.common.controller;


import com.gxa.p2p.common.query.IplogQueryObject;
import com.gxa.p2p.common.service.IplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IplogController {


    @Autowired
    private IplogService iplogService;



    @RequestMapping("ipLog")
    public String toipLog(IplogQueryObject iplogQueryObject, Model model){

        model.addAttribute("pageResultSet",iplogService.queryforPage(iplogQueryObject));

        IplogQueryObject iplogQueryObject1 = new IplogQueryObject();
        iplogQueryObject1.setBeginDate(iplogQueryObject.getBeginDate());
        iplogQueryObject1.setEndDate(iplogQueryObject.getEndDate());
        iplogQueryObject1.setState(iplogQueryObject.getState());

        model.addAttribute("iplogQueryObject", iplogQueryObject1);


        return "iplog_list";
    }

   /* @RequestMapping("ipLog")
    @ResponseBody
    public Map<String,Object> toipLog(IplogQueryObject iplogQueryObject, Model model){

        Map<String,Object> map = new HashMap<>();
        map.put("pageResultSet",iplogService.queryforPage(iplogQueryObject));

        model.addAttribute("pageResultSet",iplogService.queryforPage(iplogQueryObject));

        IplogQueryObject iplogQueryObject1 = new IplogQueryObject();
        iplogQueryObject1.setBeginDate(iplogQueryObject.getBeginDate());
        iplogQueryObject1.setEndDate(iplogQueryObject.getEndDate());
        iplogQueryObject1.setState(iplogQueryObject.getState());

        model.addAttribute("iplogQueryObject", iplogQueryObject1);
        map.put("iplogQueryObject", iplogQueryObject1);


        return map;
    }*/

}
