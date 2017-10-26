package com.ada.ad.data.service;

import com.ada.ad.data.entity.Ad;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年10月10日12:04:43.
*/
public interface AdService {

	Ad findById(Long id);

	Ad save(Ad bean);

	Ad update(Ad bean);

	Ad deleteById(Long id);
	
	Ad[] deleteByIds(Long[] ids);
	
	Page<Ad> page(Pageable pageable);
	
	Page<Ad> page(Pageable pageable, Object search);


	List<Ad> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}