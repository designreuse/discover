package com.ada.user.data.service;

import com.ada.data.rest.domain.AbstractVo;
import com.ada.discover.rest.base.ResponseObject;
import com.ada.user.data.entity.UserAccount;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.data.vo.UserAccountVo;
import com.ada.user.enums.AccountType;

import java.util.List;

/**
* Created by imake on 2017年07月20日16:24:20.
*/
public interface UserAccountService {

	public UserAccountVo reg(UserAccount bean);

	/**
	 * 修改账号密码
	 * @param user
	 * @param accountType
	 * @param oldpassword
	 * @param password
	 * @return
	 */
	AbstractVo updatePassword(Long user,AccountType accountType,String oldpassword,String password);

	public UserAccount findById(Long id);

	public UserAccount save(UserAccount bean);

	public UserAccount update(UserAccount bean);

	public UserAccount deleteById(Long id);
	
	public UserAccount[] deleteByIds(Long[] ids);
	

	public Page<UserAccount> page(Pageable pageable);
	
	public Page<UserAccount> page(Pageable pageable, Object search);


	public  List<UserAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    UserAccount findByUserName(String username, AccountType account);

	UserAccount updateUserLogin(UserAccount userAccount);


	ResponseObject restPassword(UserAccount userAccount);

}