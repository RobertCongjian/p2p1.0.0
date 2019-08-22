package com.gxa.p2p.common.domain;

import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;

public class Account {
    private Long id;

    private String tradePassword;

    private BigDecimal usableAmount= SysConstant.ZERO;

    private BigDecimal freezedAmount = SysConstant.ZERO;

    private BigDecimal borrowLimit = SysConstant.INIT_BORROW_LIMIT;

    private Integer version = 0;

    private BigDecimal unReceiveInterest=SysConstant.ZERO;

    private BigDecimal unReceivePrincipal = SysConstant.ZERO;

    private BigDecimal unReturnAmount = SysConstant.ZERO;

    private BigDecimal remainBorrowLimit = SysConstant.ZERO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public BigDecimal getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(BigDecimal usableAmount) {
        this.usableAmount = usableAmount;
    }

    public BigDecimal getFreezedAmount() {
        return freezedAmount;
    }

    public void setFreezedAmount(BigDecimal freezedAmount) {
        this.freezedAmount = freezedAmount;
    }

    public BigDecimal getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(BigDecimal borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getUnReceiveInterest() {
        return unReceiveInterest;
    }

    public void setUnReceiveInterest(BigDecimal unReceiveInterest) {
        this.unReceiveInterest = unReceiveInterest;
    }

    public BigDecimal getUnReceivePrincipal() {
        return unReceivePrincipal;
    }

    public void setUnReceivePrincipal(BigDecimal unReceivePrincipal) {
        this.unReceivePrincipal = unReceivePrincipal;
    }

    public BigDecimal getUnReturnAmount() {
        return unReturnAmount;
    }

    public void setUnReturnAmount(BigDecimal unReturnAmount) {
        this.unReturnAmount = unReturnAmount;
    }

    public BigDecimal getRemainBorrowLimit() {
        return remainBorrowLimit;
    }

    public void setRemainBorrowLimit(BigDecimal remainBorrowLimit) {
        this.remainBorrowLimit = remainBorrowLimit;
    }
}