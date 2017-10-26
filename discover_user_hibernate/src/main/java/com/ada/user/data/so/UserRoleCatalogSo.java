package com.ada.user.data.so;

import com.ada.data.page.Filter;
import com.ada.data.page.Search;

import java.io.Serializable;

/**
* Created by imake on 2017年08月09日13:36:13.
*/
public class UserRoleCatalogSo implements Serializable {

    @Search(name = "name",operator = Filter.Operator.like)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
