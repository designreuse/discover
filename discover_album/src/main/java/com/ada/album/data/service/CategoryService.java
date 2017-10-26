package com.ada.album.data.service;

import com.ada.album.data.entity.Category;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
public interface CategoryService {

	Category findById(String id);

	Category save(Category bean);

	Category update(Category bean);

	Category deleteById(String id);
	
	Category[] deleteByIds(String[] ids);
	
	Page<Category> page(Pageable pageable);
	
	Page<Category> page(Pageable pageable, Object search);


	List<Category> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}