package com.ada.data.core;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cng19 on 2016/10/23.
 */
public interface DataProvider<T, ID extends Serializable> {

    Page<T> page(Pageable pageable);

    List<T> list(Integer first, Integer count, List<Filter> filters, List<Order> orders);

    T add(T t);

    T delete(T t);

    T update(T t);


}
