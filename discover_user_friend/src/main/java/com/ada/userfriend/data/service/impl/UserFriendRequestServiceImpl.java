package com.ada.userfriend.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.userfriend.data.dao.UserFriendRequestDao;
import com.ada.userfriend.data.entity.UserFriendRequest;
import com.ada.userfriend.data.service.UserFriendRequestService;

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
public class UserFriendRequestServiceImpl implements UserFriendRequestService {

	private UserFriendRequestDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserFriendRequest findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserFriendRequest save(UserFriendRequest bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserFriendRequest update(UserFriendRequest bean) {
		Updater<UserFriendRequest> updater = new Updater<UserFriendRequest>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserFriendRequest deleteById(Long id) {
		UserFriendRequest bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserFriendRequest[] deleteByIds(Long[] ids) {
		UserFriendRequest[] beans = new UserFriendRequest[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserFriendRequestDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserFriendRequest> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserFriendRequest> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserFriendRequest> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}