package com.ada.site.freemaker;

import com.ada.common.freemarker.ListDirective;
import com.ada.data.page.Filter;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.site.data.entity.Link;
import com.ada.site.data.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LinkDirective extends ListDirective<Link> {

    @Override
    public List<Link> list() {

        Integer size =getInt("size");
        Integer id = getInt("id");
        Pageable pagex = new Pageable();
        pagex.setPageSize(size);
        pagex.setPageNumber(1);
        pagex.getFilters().add(Filter.eq("linkType.id", id));
        return linkService.list(0,size,pagex.getFilters(),pagex.getOrders());
    }

    @Autowired
    LinkService linkService;
}