package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 个人中心 - 账户信息
 *
 * @author novo
 *
 */
@Controller
public class AccountController {

	@Autowired
	private IAccountService iAccountService;


	@RequestMapping("personal")
	public String personalCenter(Model model,HttpSession session) {
		Date date = new Date();
		String stringTime;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		stringTime=sdf.format(date);
		model.addAttribute("date", stringTime);
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("logininfo");
		Account account = iAccountService.getAccountById(loginInfo.getId());
		model.addAttribute("account", account);
		List<String> list=new ArrayList<>();
		list.add(account.getUsableAmount().toString());
		list.add(account.getFreezedAmount().toString());
		list.add(account.getUnReceiveInterest().toString());
		list.add(account.getUnReceivePrincipal().toString());
		list.add(account.getUnReturnAmount().toString());
		BigDecimal count=new BigDecimal(0);
		for(String s:list) {
			count = count.add(new BigDecimal(s));
		}
		model.addAttribute("count", count);

		return "personal";
	}

}
