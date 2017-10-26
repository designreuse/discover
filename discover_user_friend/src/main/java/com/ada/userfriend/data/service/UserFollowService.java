package com.ada.userfriend.data.service;

import com.ada.data.core.Pagination;
import com.ada.userfriend.data.entity.UserFollow;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFollowService {

	UserFollow findById(Long id);

	UserFollow save(UserFollow bean);

	UserFollow update(UserFollow bean);

	UserFollow deleteById(Long id);
	
	UserFollow[] deleteByIds(Long[] ids);
	
	Page<UserFollow> page(Pageable pageable);
	
	Page<UserFollow> page(Pageable pageable, Object search);


	List<UserFollow> list(int first, Integer size, List<Filter> filters, List<Order> orders);


	UserFollow follow(UserFollow bean);

	UserFollow follow(long userid, long followid);

	UserFollow unFollow(UserFollow bean);

	UserFollow unFollow(long userid, long followid);

	UserFollow remove(UserFollow follow);
}