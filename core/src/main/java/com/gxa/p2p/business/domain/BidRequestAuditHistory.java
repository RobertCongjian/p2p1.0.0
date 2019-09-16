package com.gxa.p2p.business.domain;


/**
 * 借款申请的审核历史记录
 */

public class BidRequestAuditHistory extends BaseAuditDomain {

    public static final int PUBLISH_AUDIT = 0; //发标审核
    public static final int FULL_AUDIT1 = 1; //满标一审
    public static final int FULL_AUDIT2 = 2; //满标二审

    private Long bidRequestId;     //关联到对应的 bidRequest
    private int auditType;         //审核的类型

    public String getAuditTypeDisplay() {
        switch (this.auditType) {
            case PUBLISH_AUDIT:
                return "发标审核";
            case FULL_AUDIT1:
                return "满标一审";
            case FULL_AUDIT2:
                return "满标二审";
            default:
                return "";
        }
    }

    public Long getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(Long bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

    public int getAuditType() {
        return auditType;
    }

    public void setAuditType(int auditType) {
        this.auditType = auditType;
    }

    @Override
    public String toString() {
        return "BidRequestAuditHistory{" +
                "bidRequestId=" + bidRequestId +
                ", auditType=" + auditType +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", auditTime=" + auditTime +
                ", applyTime=" + applyTime +
                ", applier=" + applier +
                ", auditor=" + auditor +
                '}';
    }
}
