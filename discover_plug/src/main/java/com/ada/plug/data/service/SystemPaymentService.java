package com.ada.plug.data.service;

import com.ada.plug.data.entity.SystemPayment;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
public interface SystemPaymentService {

	SystemPayment findById(Long id);

	SystemPayment save(SystemPayment bean);

	SystemPayment update(SystemPayment bean);

	SystemPayment deleteById(Long id);
	
	SystemPayment[] deleteByIds(Long[] ids);
	
	Page<SystemPayment> page(Pageable pageable);
	
	Page<SystemPayment> page(Pageable pageable, Object search);


	List<SystemPayment> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}