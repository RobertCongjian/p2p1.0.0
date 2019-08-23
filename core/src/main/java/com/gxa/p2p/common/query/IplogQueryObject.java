package com.gxa.p2p.common.query;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IplogQueryObject extends QueryObject {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer state = -1;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
