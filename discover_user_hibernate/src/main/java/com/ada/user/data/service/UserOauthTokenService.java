package com.ada.user.data.service;

import com.ada.user.data.entity.UserOauthToken;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月21日16:04:29.
*/
public interface UserOauthTokenService {

	public UserOauthToken findById(Long id);

	public UserOauthToken save(UserOauthToken bean);

	public UserOauthToken update(UserOauthToken bean);

	public UserOauthToken deleteById(Long id);
	
	public UserOauthToken[] deleteByIds(Long[] ids);
	

	public Page<UserOauthToken> page(Pageable pageable);
	
	public Page<UserOauthToken> page(Pageable pageable, Object search);


	public  List<UserOauthToken> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    UserOauthToken findByUid(String ticket);
}