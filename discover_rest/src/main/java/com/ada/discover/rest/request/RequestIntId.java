package com.ada.discover.rest.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/5/16.
 */
public class RequestIntId extends RequestTokenObject {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
