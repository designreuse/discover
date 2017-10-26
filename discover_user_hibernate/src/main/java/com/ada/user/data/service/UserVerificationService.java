package com.ada.user.data.service;

import com.ada.user.data.entity.UserVerification;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年07月20日16:37:49.
*/
public interface UserVerificationService {

	public UserVerification findById(Long id);

	public UserVerification save(UserVerification bean);

	public UserVerification update(UserVerification bean);

	public UserVerification deleteById(Long id);
	
	public UserVerification[] deleteByIds(Long[] ids);
	

	public Page<UserVerification> page(Pageable pageable);
	
	public Page<UserVerification> page(Pageable pageable, Object search);


	public  List<UserVerification> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}