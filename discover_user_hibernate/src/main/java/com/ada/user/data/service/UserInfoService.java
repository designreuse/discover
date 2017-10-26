package com.ada.user.data.service;

import com.ada.user.data.entity.UserInfo;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.Collection;
import java.util.List;

/**
* Created by imake on 2017年07月20日16:35:49.
*/
public interface UserInfoService {

	public UserInfo findById(Long id);

	public UserInfo save(UserInfo bean);

	public UserInfo update(UserInfo bean);

	public UserInfo deleteById(Long id);
	
	public UserInfo[] deleteByIds(Long[] ids);
	

	public Page<UserInfo> page(Pageable pageable);
	
	public Page<UserInfo> page(Pageable pageable, Object search);


	public  List<UserInfo> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    UserInfo findByUserName(String username);

	Collection<? extends String> findAuthorities(Long id);

	void updateUserLogin(UserInfo user);
}