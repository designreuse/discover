package com.ada.album.data.service;

import com.ada.album.data.entity.Tag;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface TagService {

	Tag findById(String id);

	Tag save(Tag bean);

	Tag update(Tag bean);

	Tag deleteById(String id);
	
	Tag[] deleteByIds(String[] ids);
	
	Page<Tag> page(Pageable pageable);
	
	Page<Tag> page(Pageable pageable, Object search);


	List<Tag> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}