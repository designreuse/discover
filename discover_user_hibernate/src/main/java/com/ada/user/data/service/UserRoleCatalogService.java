package com.ada.user.data.service;

import com.ada.user.data.entity.UserRoleCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月09日13:36:13.
*/
public interface UserRoleCatalogService {

	UserRoleCatalog findById(Integer id);

	UserRoleCatalog save(UserRoleCatalog bean);

	UserRoleCatalog update(UserRoleCatalog bean);

	UserRoleCatalog deleteById(Integer id);
	
	UserRoleCatalog[] deleteByIds(Integer[] ids);
	
	Page<UserRoleCatalog> page(Pageable pageable);
	
	Page<UserRoleCatalog> page(Pageable pageable, Object search);

	List<UserRoleCatalog> findByTops(Integer pid);

	List<UserRoleCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}