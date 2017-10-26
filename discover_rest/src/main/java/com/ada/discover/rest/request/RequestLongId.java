package com.ada.discover.rest.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/5/16.
 */
public class RequestLongId extends RequestTokenObject {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
