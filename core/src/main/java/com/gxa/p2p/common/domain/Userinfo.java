package com.gxa.p2p.common.domain;

import java.util.List;

public class Userinfo {
    private Long id;

    private Integer version = 0;

    private Long bitstate = 0L;

    private String realname;

    private String idnumber;

    private String phonenumber;

    private Long incomegradeId;

    private Long marriageId;

    private Long kidcountId;

    private Long educationbackgroundId;

    private Integer authscore;

    private Long houseconditionId;

    private Long realauthid;

    private String email;



    private Systemdictionaryitem educationbackgroundItem;
    private Systemdictionaryitem incomegradeItem;
    private Systemdictionaryitem marriageItem;
    private Systemdictionaryitem kidcountItem;
    private Systemdictionaryitem houseconditionItem;

    private List<Systemdictionaryitem> systemdictionaryitems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getBitstate() {
        return bitstate;
    }

    public void setBitstate(Long bitstate) {
        this.bitstate = bitstate;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public Long getIncomegradeId() {
        return incomegradeId;
    }

    public void setIncomegradeId(Long incomegradeId) {
        this.incomegradeId = incomegradeId;
    }

    public Long getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Long marriageId) {
        this.marriageId = marriageId;
    }

    public Long getKidcountId() {
        return kidcountId;
    }

    public void setKidcountId(Long kidcountId) {
        this.kidcountId = kidcountId;
    }

    public Long getEducationbackgroundId() {
        return educationbackgroundId;
    }

    public void setEducationbackgroundId(Long educationbackgroundId) {
        this.educationbackgroundId = educationbackgroundId;
    }

    public Integer getAuthscore() {
        return authscore;
    }

    public void setAuthscore(Integer authscore) {
        this.authscore = authscore;
    }

    public Long getHouseconditionId() {
        return houseconditionId;
    }

    public void setHouseconditionId(Long houseconditionId) {
        this.houseconditionId = houseconditionId;
    }

    public Long getRealauthid() {
        return realauthid;
    }

    public void setRealauthid(Long realauthid) {
        this.realauthid = realauthid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public List<Systemdictionaryitem> getSystemdictionaryitems() {
        return systemdictionaryitems;
    }

    public void setSystemdictionaryitems(List<Systemdictionaryitem> systemdictionaryitems) {
        this.systemdictionaryitems = systemdictionaryitems;
    }

    public Systemdictionaryitem getEducationbackgroundItem() {
        return educationbackgroundItem;
    }

    public void setEducationbackgroundItem(Systemdictionaryitem educationbackgroundItem) {
        this.educationbackgroundItem = educationbackgroundItem;
    }

    public Systemdictionaryitem getIncomegradeItem() {
        return incomegradeItem;
    }

    public void setIncomegradeItem(Systemdictionaryitem incomegradeItem) {
        this.incomegradeItem = incomegradeItem;
    }

    public Systemdictionaryitem getMarriageItem() {
        return marriageItem;
    }

    public void setMarriageItem(Systemdictionaryitem marriageItem) {
        this.marriageItem = marriageItem;
    }

    public Systemdictionaryitem getKidcountItem() {
        return kidcountItem;
    }

    public void setKidcountItem(Systemdictionaryitem kidcountItem) {
        this.kidcountItem = kidcountItem;
    }

    public Systemdictionaryitem getHouseconditionItem() {
        return houseconditionItem;
    }

    public void setHouseconditionItem(Systemdictionaryitem houseconditionItem) {
        this.houseconditionItem = houseconditionItem;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", version=" + version +
                ", bitstate=" + bitstate +
                ", realname='" + realname + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", incomegradeId=" + incomegradeId +
                ", marriageId=" + marriageId +
                ", kidcountId=" + kidcountId +
                ", educationbackgroundId=" + educationbackgroundId +
                ", authscore=" + authscore +
                ", houseconditionId=" + houseconditionId +
                ", realauthid=" + realauthid +
                ", email='" + email + '\'' +
                ", systemdictionaryitems=" + systemdictionaryitems +
                '}';
    }
}