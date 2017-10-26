package com.ada.userfriend.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.userfriend.data.dao.UserFriendDao;
import com.ada.userfriend.data.entity.UserFriend;
import com.ada.userfriend.data.service.UserFriendService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年09月01日10:05:18.
*/


@Scope("prototype")
@Service
@Transactional
public class UserFriendServiceImpl implements UserFriendService {

	private UserFriendDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserFriend findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserFriend save(UserFriend bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserFriend update(UserFriend bean) {
		Updater<UserFriend> updater = new Updater<UserFriend>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserFriend deleteById(Long id) {
		UserFriend bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserFriend[] deleteByIds(Long[] ids) {
		UserFriend[] beans = new UserFriend[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserFriendDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserFriend> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserFriend> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserFriend> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}