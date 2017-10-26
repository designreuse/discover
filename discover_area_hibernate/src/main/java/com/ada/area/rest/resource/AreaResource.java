package com.ada.area.rest.resource;

import com.ada.area.api.AreaHandler;
import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.area.domain.request.AreaListRequest;
import com.ada.area.domain.request.AreaTypeRequest;
import com.ada.area.domain.response.list.AreaList;
import com.ada.area.domain.response.simple.AreaSimple;
import com.ada.area.rest.conver.AreaSimpleConver;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.user.utils.ConverResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Scope("prototype")
@Transactional
@Component
public class AreaResource implements AreaHandler {

    @Autowired
    AreaDao areaDao;

    @Override
    public AreaList list(AreaListRequest request) {

        AreaList areaList = new AreaList();
        List<Order> orders = new ArrayList<Order>();
        orders.add(Order.asc("id"));
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.eq("parent.id", request.getId()));
        List<Area> areas = areaDao.list(0, request.getSize(), filters, orders);
        List<AreaSimple> simples = ConverResourceUtils.coverList(areas, new AreaSimpleConver());
        areaList.setList(simples);

        return areaList;
    }

    @Override
    public AreaList type(AreaTypeRequest request) {
        AreaList areaList = new AreaList();
        List<Order> orders = new ArrayList<Order>();
        orders.add(Order.asc("id"));
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(Filter.eq("type", request.getType()));
        List<Area> areas = areaDao.list(0, 10000, filters, orders);
        List<AreaSimple> simples = ConverResourceUtils.coverList(areas, new AreaSimpleConver());
        areaList.setList(simples);

        return areaList;
    }
}
