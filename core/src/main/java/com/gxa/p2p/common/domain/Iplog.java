package com.gxa.p2p.common.domain;

import java.util.Date;

public class Iplog {

    public static final Byte LOGIN_SUCCESS =1 ;
    public static final Byte LOGIN_FAIL = 0 ;

    private Long id;

    private String ip;

    private Byte state;

    private String username;

    private Long logininfoid;

    private Byte usertype;

    private Date logintime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getLogininfoid() {
        return logininfoid;
    }

    public void setLogininfoid(Long logininfoid) {
        this.logininfoid = logininfoid;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}