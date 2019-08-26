package com.gxa.p2p.common.service;

public interface IVerifyCodeService {

    public void sendVerifyCode(String phoneNumber);
    public boolean validate(String phoneNumber, String verifyCode);
}
