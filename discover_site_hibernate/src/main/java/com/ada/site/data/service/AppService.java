package com.ada.site.data.service;

import com.ada.site.data.entity.App;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.List;

/**
 * Created by imake on 2017年07月25日11:33:24.
 */
public interface AppService {

    public App findById(Long id);


    App findByKey(String key);

    public App save(App bean);

    public App update(App bean);

    public App deleteById(Long id);

    public App[] deleteByIds(Long[] ids);


    public Page<App> page(Pageable pageable);

    public Page<App> page(Pageable pageable, Object search);


    public List<App> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    App visit(Long id);

    String key();

    String secret();
}