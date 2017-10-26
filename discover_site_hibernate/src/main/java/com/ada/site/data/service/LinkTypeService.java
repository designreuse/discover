package com.ada.site.data.service;

import com.ada.site.data.entity.LinkType;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月28日16:29:13.
*/
public interface LinkTypeService {

	LinkType findById(Integer id);

	LinkType save(LinkType bean);

	LinkType update(LinkType bean);

	LinkType deleteById(Integer id);
	
	LinkType[] deleteByIds(Integer[] ids);
	
	Page<LinkType> page(Pageable pageable);
	
	Page<LinkType> page(Pageable pageable, Object search);

	List<LinkType> findByTops(Integer pid);

	List<LinkType> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}