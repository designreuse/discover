package com.ada.area.freemarker;

import com.ada.area.data.entity.Area;
import com.ada.area.data.service.AreaService;
import com.ada.common.freemarker.ListDirective;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cng19 on 2017/9/3.
 */
public class AreaDirective extends ListDirective<Area> {

    @Override
    public List<Area> list() {

        Integer size =getInt("size");
        Integer id = getInt("id");
        Pageable pagex = new Pageable();
        pagex.setPageSize(size);
        pagex.setPageNumber(1);
        pagex.getFilters().add(Filter.eq("parent.id", id));
        pagex.getOrders().add(Order.asc("code"));
        return areaService.list(0,size,pagex.getFilters(),pagex.getOrders());
    }

    @Autowired
    AreaService areaService;
}