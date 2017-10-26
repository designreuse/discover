package com.ada.site.data.service;

import com.ada.site.data.entity.AppVersion;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
public interface AppVersionService {

	public AppVersion findById(Long id);

	public AppVersion save(AppVersion bean);

	public AppVersion update(AppVersion bean);

	public AppVersion deleteById(Long id);
	
	public AppVersion[] deleteByIds(Long[] ids);
	

	public Page<AppVersion> page(Pageable pageable);
	
	public Page<AppVersion> page(Pageable pageable, Object search);


	public  List<AppVersion> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}