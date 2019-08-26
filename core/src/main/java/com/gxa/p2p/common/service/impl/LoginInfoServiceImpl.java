package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.Account;
import com.gxa.p2p.common.domain.Iplog;
import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.AccountMapper;
import com.gxa.p2p.common.mapper.IplogMapper;
import com.gxa.p2p.common.mapper.LoginInfoMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.query.PageResultSet;
import com.gxa.p2p.common.service.IAccountService;
import com.gxa.p2p.common.service.ILoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class LoginInfoServiceImpl implements ILoginInfoService {
    @Autowired
    private LoginInfoMapper logininfoMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IplogMapper iplogMapper;

    /**
     * 检查用户名是否已存在
     *
     * @param username
     * @return 返回用户个数
     */
    @Override
    public int checkUsername(String username) {
        int count = logininfoMapper.selectCountByUsername(username);
        return count;
    }


    /**
     * 新用户注册
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        /*
         * 逻辑思路
         * 1. 判断用户名是否存在
         * 2. 如果不存在,设值并保存这个对象
         * 3. 如果存在,直接抛错
         *
         */
        int count = checkUsername(username);

        if (count <= 0) {
            LoginInfo li = new LoginInfo();
            li.setUsername(username);
            li.setPassword(password);
            li.setState(LoginInfo.STATE_NORMAL);
            li.setUsertype(LoginInfo.Type_NORMAL);
            logininfoMapper.insert(li);
            Long id = li.getId();
            Account account = new Account();
            account.setId(id);
            int row = accountMapper.insertAccount(account);
            if(row!=1){
                throw new RuntimeException("生成账户失败！");
            }
            Userinfo userinfo = new Userinfo();
            userinfo.setId(id);
            userinfo.setRealname(username);
            userinfoMapper.insert(userinfo);
        } else {
            // 如果存在,直接抛错
            throw new RuntimeException("用户名已经存在!");
        }

    }

    @Override
    public LoginInfo login(String username, String password, int usertype, HttpServletRequest request) {
        LoginInfo loginInfo = logininfoMapper.login(username,password,usertype);
        Iplog iplog = new Iplog();
        iplog.setIp(request.getRemoteAddr());
        iplog.setUsername(username);
        iplog.setLogintime(new Date());
        if(loginInfo!=null){
            iplog.setState(Iplog.LOGIN_SUCCESS);
            iplogMapper.insert(iplog);

        }else {
            iplog.setState(Iplog.LOGIN_FAIL);
            iplogMapper.insert(iplog);

        }
        return loginInfo;

    }

    @Override
    public PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject) {
        int count = logininfoMapper.queryForCount();

        PageResultSet pageResultSet;
        //如果存在符合条件的数据，对数据进行分页查询，获取当前页的数据;没有则返回空的数据集
        if (count > 0) {
            List<LoginInfo> list = logininfoMapper.queryForPage(loginInfoQueryObject);
            for(LoginInfo loginInfo:list){
                System.err.println(loginInfo.toString());
                System.out.println();
            }
            pageResultSet = new PageResultSet(
                    list,
                    count,
                    loginInfoQueryObject.getCurrentPage(),
                    loginInfoQueryObject.getPageSize());
        } else {
            pageResultSet = PageResultSet.empty(loginInfoQueryObject.getPageSize());
        }

        return pageResultSet;

    }
}
