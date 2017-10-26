package com.ada.user.data.service.impl;

import com.ada.data.core.Finder;
import com.ada.user.data.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserInfoDao;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.service.UserInfoService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.*;

import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月20日16:35:49.
*/
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserInfo findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserInfo save(UserInfo bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserInfo update(UserInfo bean) {
		Updater<UserInfo> updater = new Updater<UserInfo>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserInfo deleteById(Long id) {
		UserInfo bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserInfo[] deleteByIds(Long[] ids) {
		UserInfo[] beans = new UserInfo[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserInfo> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserInfo> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserInfo> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public UserInfo findByUserName(String username) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
		}
		return result;
	}

	@Override
	public Collection<? extends String> findAuthorities(Long id) {
		List<String> authorities = new ArrayList<String>();
		UserInfo admin = dao.findById(id);
		if (admin != null) {
			for (UserRole role : admin.getRoles()) {
				authorities.addAll(role.getAuthorities());
			}
		}
		return authorities;
	}

	@Override
	public void updateUserLogin(UserInfo user) {
		user = dao.findById(user.getId());
		user.setLastDate(new Date());
		Integer times = user.getLoginSize();
		if (times == null) {
			times = 0;
		}
		times++;
		user.setLoginSize(times);
	}
}