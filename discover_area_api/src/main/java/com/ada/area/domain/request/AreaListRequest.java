package com.ada.area.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;
import com.ada.discover.rest.base.RequestTokenPageObject;

public class AreaListRequest extends RequestTokenPageObject {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
