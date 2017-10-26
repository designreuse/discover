package com.ada.data.core;

import java.io.Serializable;
import java.util.List;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

public interface CriteriaDao<T, ID extends Serializable> extends BaseDao<T, ID> {
	Page<T> findPage(Pageable pageable);

	long count(Filter... filters);

	List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
}
