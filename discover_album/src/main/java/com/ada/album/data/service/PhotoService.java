package com.ada.album.data.service;

import com.ada.album.data.entity.Photo;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface PhotoService {

	Photo findById(String id);

	Photo save(Photo bean);

	Photo update(Photo bean);

	Photo deleteById(String id);
	
	Photo[] deleteByIds(String[] ids);
	
	Page<Photo> page(Pageable pageable);
	
	Page<Photo> page(Pageable pageable, Object search);


	List<Photo> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}