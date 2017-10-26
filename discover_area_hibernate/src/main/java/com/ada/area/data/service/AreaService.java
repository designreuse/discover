package com.ada.area.data.service;

import com.ada.area.data.entity.Area;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.List;

/**
 * Created by imake on 2017年08月04日10:01:33.
 */
public  interface AreaService {

    Area findById(Integer id);

    Area save(Area bean);

    Area update(Area bean);

    Area deleteById(Integer id);

    Area[] deleteByIds(Integer[] ids);

    Area findByName(String name);


    Page<Area> page(Pageable pageable);

    Page<Area> page(Pageable pageable, Object search);


    List<Area> findByTops(Integer pid);

    List<Area> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}