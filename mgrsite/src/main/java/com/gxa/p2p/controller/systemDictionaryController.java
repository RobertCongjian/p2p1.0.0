package com.gxa.p2p.controller;


import com.gxa.p2p.common.domain.Systemdictionary;
import com.gxa.p2p.common.service.SystemDictionaryService;
import com.gxa.p2p.common.service.SystemdictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class systemDictionaryController {



    @Autowired
    private SystemDictionaryService systemDictionaryService;

    @Autowired
    private SystemdictionaryItemService systemdictionaryItemService;

    @RequestMapping("/systemDictionary_list")
    public String systemDictionaryList(Model model){


        model.addAttribute("systemdictionarys", systemDictionaryService.getAllInfo());
        return "systemDictionary/systemDictionary";
    }



    @RequestMapping("/systemDictionaryItem_list")
    public String systemDictionaryItemList(Model model){

        model.addAttribute("systemDictionaryItemList",systemdictionaryItemService.getAllInfo());
        return  "systemDictionary/systemDictionaryItem";
    }

}
