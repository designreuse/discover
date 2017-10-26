package com.ada.site.data.service;

import com.ada.site.data.entity.Link;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月25日11:33:25.
*/
public interface LinkService {

	public Link findById(Long id);

	public Link save(Link bean);

	public Link update(Link bean);

	public Link deleteById(Long id);
	
	public Link[] deleteByIds(Long[] ids);
	

	public Page<Link> page(Pageable pageable);
	
	public Page<Link> page(Pageable pageable, Object search);


	public  List<Link> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}