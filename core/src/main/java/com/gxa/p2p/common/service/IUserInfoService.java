package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface IUserInfoService {
    Map<String,Object> getInfo(HttpSession session);

    void updateItem(Userinfo userinfo,Long id);


    List<Systemdictionaryitem> selectItemBysn(String incomeGrades);

    Userinfo  getUserInfoById(Long id);
}
