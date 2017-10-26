package com.ada.article.data.so;

import com.ada.data.page.Filter;
import com.ada.data.page.Search;

import java.io.Serializable;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
public class ArticleSo implements Serializable {

    @Search(name = "title",operator = Filter.Operator.like)
    private String title;

    @Search(name = "catalog.id",operator = Filter.Operator.eq)
    private Integer catalog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }
}
