package com.ada.discover.rest.base;

import java.util.List;

/**
 * Created by ada on 2017/5/16.
 */
public class ResponseList<T> extends ResponseObject {

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
