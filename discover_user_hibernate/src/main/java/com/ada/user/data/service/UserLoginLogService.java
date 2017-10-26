package com.ada.user.data.service;

import com.ada.user.data.entity.UserLoginLog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月21日15:55:37.
*/
public interface UserLoginLogService {

	public UserLoginLog findById(Long id);

	public UserLoginLog save(UserLoginLog bean);

	public UserLoginLog update(UserLoginLog bean);

	public UserLoginLog deleteById(Long id);
	
	public UserLoginLog[] deleteByIds(Long[] ids);
	

	public Page<UserLoginLog> page(Pageable pageable);
	
	public Page<UserLoginLog> page(Pageable pageable, Object search);


	public  List<UserLoginLog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}