package com.ada.discover.rest.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/5/16.
 */
public class RequestSimple extends RequestTokenObject {

    private int no;

    private int size;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSize() {
        if (size > 100) {
            return 100;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
