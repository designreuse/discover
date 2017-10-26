package com.ada.discover.rest.base;

/**
 * Created by ada on 2017/7/22.
 */
public class RequestTokenPageObject extends RequestTokenObject {

    private Integer no;

    private Integer size;

    public Integer getNo() {
        if (no == null) {
            return 1;
        }
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getSize() {
        if (size == null) {
            return 10;
        }
        if (size > 100) {
            return 100;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
