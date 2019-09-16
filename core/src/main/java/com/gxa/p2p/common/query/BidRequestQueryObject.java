package com.gxa.p2p.common.query;

public class BidRequestQueryObject extends QueryObject {

    private Integer bidRequestState = -1;

    /**
     * 多个借款状态
     */
    private int[] states ;
    private String orderBy ;  //按照哪个列排序
    private String orderType;  //按照什么顺序配列


    public Integer getBidRequestState() {
        return bidRequestState;
    }

    public void setBidRequestState(Integer bidRequestState) {
        this.bidRequestState = bidRequestState;
    }


    public int[] getStates() {
        return states;
    }

    public void setStates(int[] states) {
        this.states = states;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
