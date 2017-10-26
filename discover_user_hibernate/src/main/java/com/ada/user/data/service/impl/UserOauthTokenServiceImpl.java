package com.ada.user.data.service.impl;

import com.ada.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserOauthTokenDao;
import com.ada.user.data.entity.UserOauthToken;
import com.ada.user.data.service.UserOauthTokenService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月21日16:04:29.
*/
@Service
@Transactional
public class UserOauthTokenServiceImpl implements UserOauthTokenService {

	private UserOauthTokenDao dao;


	@Override
	public UserOauthToken findByUid(String uid) {


		Finder finder=Finder.create();
		finder.append("from UserOauthToken u where u.uid=:uid");
		finder.setParam("uid",uid);
		return dao.findOne(finder);
	}
	@Override
	@Transactional(readOnly = true)
	public UserOauthToken findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserOauthToken save(UserOauthToken bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserOauthToken update(UserOauthToken bean) {
		Updater<UserOauthToken> updater = new Updater<UserOauthToken>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserOauthToken deleteById(Long id) {
		UserOauthToken bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserOauthToken[] deleteByIds(Long[] ids) {
		UserOauthToken[] beans = new UserOauthToken[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserOauthTokenDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserOauthToken> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserOauthToken> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserOauthToken> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}