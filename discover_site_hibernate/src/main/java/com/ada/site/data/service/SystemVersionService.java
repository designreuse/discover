package com.ada.site.data.service;

import com.ada.site.data.entity.SystemVersion;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日13:28:19.
*/
public interface SystemVersionService {

	SystemVersion findById(Long id);

	SystemVersion save(SystemVersion bean);

	SystemVersion update(SystemVersion bean);

	SystemVersion deleteById(Long id);
	
	SystemVersion[] deleteByIds(Long[] ids);
	
	Page<SystemVersion> page(Pageable pageable);
	
	Page<SystemVersion> page(Pageable pageable, Object search);


	List<SystemVersion> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}