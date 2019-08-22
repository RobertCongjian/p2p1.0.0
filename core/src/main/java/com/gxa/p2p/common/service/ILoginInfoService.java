package com.gxa.p2p.common.service;

import com.gxa.p2p.common.domain.LoginInfo;

public interface ILoginInfoService {
    int checkUsername(String username);

    void register(String username, String password);

    LoginInfo login(String username, String password,int usertype);
}
