package com.ada.discover.rest.base;

/**
 * 返回分页对象
 * Created by ada on 2017/5/16.
 */
public class ResponsePage<T> extends ResponseList<T> {
    /**
     * 当前页码
     */
    private int no;

    /**
     * 分页大小
     */
    private int size;

    /**
     * 数据合计
     */
    private int total;

    /**
     * 总共有多少页
     */
    private int totalPage;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
