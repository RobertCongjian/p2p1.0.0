package com.gxa.p2p.common.query;


/**
 * 用户账户信息model
 *
 * @author novo
 */
abstract public class QueryObject {

    private Integer currentPage = 1; //当前页数
    private Integer pageSize = 5;    //每页显示的数据量

    /**
     * 数据的起始位置
     *
     * @return
     */
    public int getStart() {
        return (currentPage - 1) * pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
