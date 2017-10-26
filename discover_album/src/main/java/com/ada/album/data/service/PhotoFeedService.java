package com.ada.album.data.service;

import com.ada.album.data.entity.PhotoFeed;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface PhotoFeedService {

	PhotoFeed findById(Long id);

	PhotoFeed save(PhotoFeed bean);

	PhotoFeed update(PhotoFeed bean);

	PhotoFeed deleteById(Long id);
	
	PhotoFeed[] deleteByIds(Long[] ids);
	
	Page<PhotoFeed> page(Pageable pageable);
	
	Page<PhotoFeed> page(Pageable pageable, Object search);


	List<PhotoFeed> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}