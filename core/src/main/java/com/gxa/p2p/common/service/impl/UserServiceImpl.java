package com.gxa.p2p.common.service.impl;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.SystemdictionaryitemMapper;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;


    @Override
    public Map<String,Object> getInfo(HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("logininfo");
        map.put("userinfo",userinfoMapper.getUserInfoAndSystemdictionaryById(loginInfo.getId()));
        map.put("systemdictionaryitem",systemdictionaryitemMapper.selectAll());
        return map;

    }


    @Override
    public List<Systemdictionaryitem> selectItemBysn(String sn) {
        return systemdictionaryitemMapper.selectItemBysn(sn);
    }

    @Override
    public Userinfo getUserInfoById(Long id) {
        return userinfoMapper.getUserInfoAndSystemdictionaryById(id);
    }

    @Override
    public void updateItem(Userinfo userinfo,Long id) {

        int row = userinfoMapper.updateItem(userinfo,id);
        System.out.println(row);
        if(row!=1){
            throw new RuntimeException("更新失败！");
        }
    }
}
