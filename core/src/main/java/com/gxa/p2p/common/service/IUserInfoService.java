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

    /**
     *
     * 用户绑定手机
     *
     * @param phoneNumber
     * @param verifyCode
     */
    void bindPhone(String phoneNumber, String verifyCode);

    /**
     * 绑定邮箱
     *
     * @param uuid
     */
    void bindEmail(String uuid);


}
