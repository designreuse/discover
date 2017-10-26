package com.ada.web.data.service;

import com.ada.web.data.entity.WebConfig;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月30日09:46:28.
*/
public interface WebConfigService {

	WebConfig findById(Long id);

	WebConfig save(WebConfig bean);

	WebConfig update(WebConfig bean);

	WebConfig deleteById(Long id);
	
	WebConfig[] deleteByIds(Long[] ids);
	
	Page<WebConfig> page(Pageable pageable);
	
	Page<WebConfig> page(Pageable pageable, Object search);


	List<WebConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}