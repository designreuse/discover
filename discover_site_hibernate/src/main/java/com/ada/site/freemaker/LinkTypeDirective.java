package com.ada.site.freemaker;

import com.ada.common.freemarker.ListDirective;
import com.ada.common.utils.DirectiveUtils;
import com.ada.data.page.Filter;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.site.data.entity.Link;
import com.ada.site.data.entity.LinkType;
import com.ada.site.data.service.LinkTypeService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LinkTypeDirective extends ListDirective<LinkType> {


    @Override
    public List<LinkType> list() {

        Integer size =getInt("size");
        Integer id =getInt("id");
        Pageable pagex = new Pageable();
        pagex.setPageSize(size);
        pagex.setPageNumber(1);
        pagex.getFilters().add(Filter.eq("parent.id", id));
        return linkTypeService.list(0,size,pagex.getFilters(),pagex.getOrders());
    }

    @Autowired
    LinkTypeService linkTypeService;
}