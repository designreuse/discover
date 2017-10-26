package com.ada.user.data.service;

import com.ada.user.data.entity.UserRole;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
public interface UserRoleService {

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole update(UserRole bean);

	public UserRole deleteById(Long id);
	
	public UserRole[] deleteByIds(Long[] ids);
	

	public Page<UserRole> page(Pageable pageable);
	
	public Page<UserRole> page(Pageable pageable, Object search);


	public  List<UserRole> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}