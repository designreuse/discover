package com.ada.quartz.data.service;

import com.ada.quartz.data.entity.CronTask;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月24日14:31:27.
*/
public interface CronTaskService {

	CronTask findById(Long id);

	CronTask save(CronTask bean);

	CronTask update(CronTask bean);

	CronTask deleteById(Long id);
	
	CronTask[] deleteByIds(Long[] ids);
	
	Page<CronTask> page(Pageable pageable);
	
	Page<CronTask> page(Pageable pageable, Object search);


	List<CronTask> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}