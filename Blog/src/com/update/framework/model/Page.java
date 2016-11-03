/**
 * 
 */
package com.update.framework.model;

import java.util.List;

/**
 * 
 * @author cw
 * @date 2016年10月31日
 * @vsersion 1.0
 * DOTO  分页对象
 */
public class Page<T extends Object> {
    /**
     * 当前页
     */
    private int currentPageNo;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 总的记录数
     */
    private int totalRows;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页的结果集
     */
    private List<T> data;

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        this.currentPageNo = currentPage;
        this.pageSize = pageSize;
    }

    public Page(int currentPage, int pageSize, int totalCount) {
        // 1.如果传入负数
        this.currentPageNo = currentPage < 1 ? 1 : currentPage;
        this.pageSize = pageSize < 1 ? 10 : pageSize;
        this.totalRows = totalCount;
        this.totalPage = (this.totalRows + this.pageSize - 1) / this.pageSize;
        // 3.处理当前页码必须小于总的页数
        this.currentPageNo = this.currentPageNo >= this.totalPage ? this.totalPage : this.currentPageNo;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPage) {
        this.currentPageNo = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalCount) {
        this.totalRows = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageResult [currentPage=" + currentPageNo + ", pageSize=" + pageSize + ", totalCount=" + totalRows + ", totalPage=" + totalPage + ", rows=" + data.size() + "]";
    }
}
