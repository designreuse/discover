package com.ada.activity.data.service;

import com.ada.activity.data.entity.Activity;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:57:56.
*/
public interface ActivityService {

	Activity findById(Long id);

	Activity save(Activity bean);

	Activity update(Activity bean);

	Activity deleteById(Long id);
	
	Activity[] deleteByIds(Long[] ids);
	
	Page<Activity> page(Pageable pageable);
	
	Page<Activity> page(Pageable pageable, Object search);


	List<Activity> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}