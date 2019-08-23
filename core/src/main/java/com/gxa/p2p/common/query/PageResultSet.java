package com.gxa.p2p.common.query;


import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页查询的结果集对象
 */
@Alias("PageResultSet")
public class PageResultSet {

    private List listData;           //当前页的结果集数据:查询
    private Integer totalCount;      //总数据条数:查询
    private Integer currentPage; //当前页数
    private Integer pageSize;    //每页显示的数据量

    private Integer totalPage;      //总页数
/*    private Integer previousPage;   //上一页
    private Integer nextPage;       //下一页*/


    public PageResultSet() {
    }

    /**
     * 通过构造方法初始化相关分页数据
     *
     * @param listData
     * @param totalCount
     * @param currentPage
     * @param pageSize
     */
    public PageResultSet(List listData, Integer totalCount, Integer currentPage, Integer pageSize) {

        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
/*        this.previousPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;*/
    }

    // 如果总数据条数为0,返回一个空集
    public static PageResultSet empty(Integer pageSize) {
        return new PageResultSet(
                new ArrayList<>(),
                0,
                1,
                pageSize);
    }

    // 如果总页数为0,设置为1页
    public int getTotalPage() {

        return totalPage == 0 ? 1 : totalPage;
    }


    public List getListData() {

        return listData;
    }

    public void setListData(List listData) {

        this.listData = listData;
    }

    public Integer getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {

        this.totalCount = totalCount;
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

/*    public Integer getPreviousPage() {

        return previousPage;
    }

    public void setPreviousPage(Integer previousPage) {

        this.previousPage = previousPage;
    }

    public Integer getNextPage() {

        return nextPage;
    }

    public void setNextPage(Integer nextPage) {

        this.nextPage = nextPage;
    }*/

    public void setTotalPage(Integer totalPage) {

        this.totalPage = totalPage;
    }
}
