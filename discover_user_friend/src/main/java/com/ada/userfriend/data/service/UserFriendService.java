package com.ada.userfriend.data.service;

import com.ada.userfriend.data.entity.UserFriend;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFriendService {

	UserFriend findById(Long id);

	UserFriend save(UserFriend bean);

	UserFriend update(UserFriend bean);

	UserFriend deleteById(Long id);
	
	UserFriend[] deleteByIds(Long[] ids);
	
	Page<UserFriend> page(Pageable pageable);
	
	Page<UserFriend> page(Pageable pageable, Object search);


	List<UserFriend> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}