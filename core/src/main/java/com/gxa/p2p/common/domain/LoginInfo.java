package com.gxa.p2p.common.domain;

public class LoginInfo {

    public static final Byte STATE_NORMAL = 0;
    public static final String SUCCESS_MSG = "登陆成功";
    public static final int USER_MGR = 0;
    public static final int USER_WEB = 1;
    public static Byte Type_NORMAL = 1;

    private Long id;

    private String username;

    private String password;

    private Byte state;

    private Byte usertype;

    private Boolean admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}