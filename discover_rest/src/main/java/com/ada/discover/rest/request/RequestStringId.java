package com.ada.discover.rest.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/5/16.
 */
public class RequestStringId extends RequestTokenObject {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
