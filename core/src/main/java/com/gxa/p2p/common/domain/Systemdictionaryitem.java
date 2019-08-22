package com.gxa.p2p.common.domain;

public class Systemdictionaryitem {
    private Long id;

    private Long parentid;

    private String title;

    private String tvalue;

    private Byte sequence;

    private String intro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTvalue() {
        return tvalue;
    }

    public void setTvalue(String tvalue) {
        this.tvalue = tvalue == null ? null : tvalue.trim();
    }

    public Byte getSequence() {
        return sequence;
    }

    public void setSequence(Byte sequence) {
        this.sequence = sequence;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    @Override
    public String toString() {
        return "Systemdictionaryitem{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", title='" + title + '\'' +
                ", tvalue='" + tvalue + '\'' +
                ", sequence=" + sequence +
                ", intro='" + intro + '\'' +
                '}';
    }
}