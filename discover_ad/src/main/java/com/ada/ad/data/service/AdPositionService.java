package com.ada.ad.data.service;

import com.ada.ad.data.entity.AdPosition;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年10月10日13:39:55.
*/
public interface AdPositionService {

	AdPosition findById(Integer id);

	AdPosition save(AdPosition bean);

	AdPosition update(AdPosition bean);

	AdPosition deleteById(Integer id);
	
	AdPosition[] deleteByIds(Integer[] ids);
	
	Page<AdPosition> page(Pageable pageable);
	
	Page<AdPosition> page(Pageable pageable, Object search);

	List<AdPosition> findByTops(Integer pid);


    List<AdPosition> child(Integer id,Integer max);

	List<AdPosition> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}