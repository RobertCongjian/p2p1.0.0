package com.gxa.p2p.controller;


import com.gxa.p2p.business.domain.BidRequest;
import com.gxa.p2p.business.domain.BidRequestAuditHistory;
import com.gxa.p2p.common.query.BidRequestQueryObject;
import com.gxa.p2p.common.service.BidRequestAuditHistoryService;
import com.gxa.p2p.common.service.BidRequestService;
import com.gxa.p2p.common.util.JSONResult;
import com.gxa.p2p.common.util.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
public class BidRequestListController {

    @Autowired
    private BidRequestAuditHistoryService bidRequestAuditHistoryService;

    @Autowired
    private BidRequestService bidRequestService;




    @RequestMapping("bidrequest_publishaudit_list")
    public String bidRequestPublishAudit(Model model, BidRequestQueryObject bidRequestQueryObject){



        model.addAttribute("pageResult",bidRequestService.queryForPage(bidRequestQueryObject, SysConstant.BIDREQUEST_STATE_PUBLISH_PENDING));
        return "bidrequest/publish_audit";
    }


    @RequestMapping("bidrequest_audit1_list")
    public String bidRequestAudit1List(Model model,BidRequestQueryObject bidRequestQueryObject){

        model.addAttribute("pageResult", bidRequestService.queryForPage(bidRequestQueryObject, SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_1));
        return "bidrequest/publish_audit";

    }

    @RequestMapping("bidrequest_audit2_list")
    public String bidRequestAudit2List(Model model,BidRequestQueryObject bidRequestQueryObject){

        model.addAttribute("pageResult", bidRequestService.queryForPage(bidRequestQueryObject, SysConstant.BIDREQUEST_STATE_APPROVE_PENDING_2));
        return "bidrequest/publish_audit";

    }


    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public JSONResult bidRequestPublishAudit(BidRequestAuditHistory bidRequestAuditHistory){


        JSONResult jsonResult = new JSONResult();
        int row = bidRequestAuditHistoryService.insertInfo(bidRequestAuditHistory);
        if(row == 2){
            jsonResult.setSuccess(true);
        }else {
            jsonResult.setSuccess(false);

        }

        return jsonResult;

    }


    @RequestMapping("borrow_info")
    public String getBorrowInfo(Long id,Model model){

        Map<String,Object> map = bidRequestService.queryInfoById(id);
        model.addAttribute("bidRequest",map.get("bidRequest"));
        model.addAttribute("audits", map.get("audits"));
        model.addAttribute("userInfo", map.get("userInfo"));

        return "bidrequest/borrow_info";
    }
}
