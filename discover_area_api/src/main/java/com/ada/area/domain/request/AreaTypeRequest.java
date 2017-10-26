package com.ada.area.domain.request;

import com.ada.discover.rest.base.RequestTokenPageObject;

public class AreaTypeRequest extends RequestTokenPageObject {

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
