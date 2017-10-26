package com.ada.web.data.service;

import com.ada.web.data.entity.WebTheme;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月30日10:16:29.
*/
public interface WebThemeService {

	WebTheme findById(String id);

	WebTheme key(String name);


	WebTheme save(WebTheme bean);

	WebTheme update(WebTheme bean);

	WebTheme deleteById(String id);
	
	WebTheme[] deleteByIds(String[] ids);
	
	Page<WebTheme> page(Pageable pageable);
	
	Page<WebTheme> page(Pageable pageable, Object search);


	List<WebTheme> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}