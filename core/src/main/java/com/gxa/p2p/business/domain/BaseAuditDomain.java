package com.gxa.p2p.business.domain;

import com.gxa.p2p.common.domain.LoginInfo;

import java.util.Date;

/**
 * 抽取需要审核对象的基类
 */
public abstract class BaseAuditDomain {

    public static final int STATE_NORMAL = 0; // 待审核
    public static final int STATE_AUDIT = 1; // 审核通过
    public static final int STATE_REJECT = 2; // 审核拒绝


    protected int state;     // 审核状态
    protected String remark; // 审核备注
    protected Date auditTime;// 审核时间
    protected Date applyTime;// 申请时间
    protected LoginInfo applier; // 申请人
    protected LoginInfo auditor;// 审核人

    private Long auditorId;

    private Long applierId;



    public String getStateDisplay() {
        switch (state) {
            case STATE_NORMAL:
                return "待审核";
            case STATE_AUDIT:
                return "审核通过";
            case STATE_REJECT:
                return "审核拒绝";
            default:
                return "";
        }
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public Long getApplierId() {
        return applierId;
    }

    public void setApplierId(Long applierId) {
        this.applierId = applierId;
    }

    public static int getStateNormal() {
        return STATE_NORMAL;
    }

    public static int getStateAudit() {
        return STATE_AUDIT;
    }

    public static int getStateReject() {
        return STATE_REJECT;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public LoginInfo getApplier() {
        return applier;
    }

    public void setApplier(LoginInfo applier) {
        this.applier = applier;
    }

    public LoginInfo getAuditor() {
        return auditor;
    }

    public void setAuditor(LoginInfo auditor) {
        this.auditor = auditor;
    }
}
