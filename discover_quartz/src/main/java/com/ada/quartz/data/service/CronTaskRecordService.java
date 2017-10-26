package com.ada.quartz.data.service;

import com.ada.quartz.data.entity.CronTaskRecord;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月24日14:40:18.
*/
public interface CronTaskRecordService {

	CronTaskRecord findById(Long id);

	CronTaskRecord save(CronTaskRecord bean);

	CronTaskRecord update(CronTaskRecord bean);

	CronTaskRecord deleteById(Long id);
	
	CronTaskRecord[] deleteByIds(Long[] ids);
	
	Page<CronTaskRecord> page(Pageable pageable);
	
	Page<CronTaskRecord> page(Pageable pageable, Object search);


	List<CronTaskRecord> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}