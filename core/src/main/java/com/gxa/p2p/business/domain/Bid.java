package com.gxa.p2p.business.domain;

import com.gxa.p2p.common.domain.LoginInfo;

import java.math.BigDecimal;
import java.util.Date;

public class Bid {


    private Long id;

    private Long bidUserId;

    private BigDecimal actualRate;

    private BigDecimal availableAmount;

    private Date bidTime;

    private Long bidRequestId;

    private LoginInfo bidUser;

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", bidUserId=" + bidUserId +
                ", actualRate=" + actualRate +
                ", availableAmount=" + availableAmount +
                ", bidTime=" + bidTime +
                ", bidRequestId=" + bidRequestId +
                ", bidUser=" + bidUser +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBidUserId() {
        return bidUserId;
    }

    public void setBidUserId(Long bidUserId) {
        this.bidUserId = bidUserId;
    }

    public void setBidRequestId(Long bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

    public BigDecimal getActualRate() {
        return actualRate;
    }

    public void setActualRate(BigDecimal actualRate) {
        this.actualRate = actualRate;
    }

    public Long getBidRequestId() {
        return bidRequestId;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }


    public LoginInfo getBidUser() {
        return bidUser;
    }

    public void setBidUser(LoginInfo bidUser) {
        this.bidUser = bidUser;
    }
}
