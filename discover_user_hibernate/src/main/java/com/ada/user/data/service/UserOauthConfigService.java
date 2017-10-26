package com.ada.user.data.service;

import com.ada.user.data.entity.UserOauthConfig;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
public interface UserOauthConfigService {

	public UserOauthConfig findById(Long id);

	public UserOauthConfig save(UserOauthConfig bean);

	public UserOauthConfig update(UserOauthConfig bean);

	public UserOauthConfig deleteById(Long id);
	
	public UserOauthConfig[] deleteByIds(Long[] ids);
	

	public Page<UserOauthConfig> page(Pageable pageable);
	
	public Page<UserOauthConfig> page(Pageable pageable, Object search);


	public  List<UserOauthConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}