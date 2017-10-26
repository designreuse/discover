package com.ada.userfriend.data.service;

import com.ada.userfriend.data.entity.UserFriendRequest;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFriendRequestService {

	UserFriendRequest findById(Long id);

	UserFriendRequest save(UserFriendRequest bean);

	UserFriendRequest update(UserFriendRequest bean);

	UserFriendRequest deleteById(Long id);
	
	UserFriendRequest[] deleteByIds(Long[] ids);
	
	Page<UserFriendRequest> page(Pageable pageable);
	
	Page<UserFriendRequest> page(Pageable pageable, Object search);


	List<UserFriendRequest> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}