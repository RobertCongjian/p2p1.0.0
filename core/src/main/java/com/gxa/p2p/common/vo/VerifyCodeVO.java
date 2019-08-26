package com.gxa.p2p.common.vo;

import java.util.Date;

/**
 * 封装了验证码 手机号 发送时间
 */

public class VerifyCodeVO {


    private String phoneNumber;
    private String verifyCode;
    private Date sendTime;

    public VerifyCodeVO() {
    }


    public VerifyCodeVO(String phoneNumber, String verifyCode, Date sendTime) {
        this.phoneNumber = phoneNumber;
        this.verifyCode = verifyCode;
        this.sendTime = sendTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}


