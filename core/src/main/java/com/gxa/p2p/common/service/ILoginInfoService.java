package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.LoginInfo;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import com.gxa.p2p.common.query.PageResultSet;

import javax.servlet.http.HttpServletRequest;

public interface ILoginInfoService {
    int checkUsername(String username);

    void register(String username, String password);

    LoginInfo login(String username, String password, int usertype, HttpServletRequest request);

    PageResultSet queryForPage(LoginInfoQueryObject loginInfoQueryObject);
}
