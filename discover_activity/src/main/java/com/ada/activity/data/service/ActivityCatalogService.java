package com.ada.activity.data.service;

import com.ada.activity.data.entity.ActivityCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:57:56.
*/
public interface ActivityCatalogService {

	ActivityCatalog findById(Integer id);

	ActivityCatalog save(ActivityCatalog bean);

	ActivityCatalog update(ActivityCatalog bean);

	ActivityCatalog deleteById(Integer id);
	
	ActivityCatalog[] deleteByIds(Integer[] ids);
	
	Page<ActivityCatalog> page(Pageable pageable);
	
	Page<ActivityCatalog> page(Pageable pageable, Object search);

	List<ActivityCatalog> findByTops(Integer pid);

	List<ActivityCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}