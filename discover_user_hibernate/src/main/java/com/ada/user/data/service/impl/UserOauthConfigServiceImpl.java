package com.ada.user.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserOauthConfigDao;
import com.ada.user.data.entity.UserOauthConfig;
import com.ada.user.data.service.UserOauthConfigService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月20日17:47:47.
*/
@Service
@Transactional
public class UserOauthConfigServiceImpl implements UserOauthConfigService {

	private UserOauthConfigDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserOauthConfig findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserOauthConfig save(UserOauthConfig bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserOauthConfig update(UserOauthConfig bean) {
		Updater<UserOauthConfig> updater = new Updater<UserOauthConfig>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserOauthConfig deleteById(Long id) {
		UserOauthConfig bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserOauthConfig[] deleteByIds(Long[] ids) {
		UserOauthConfig[] beans = new UserOauthConfig[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserOauthConfigDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserOauthConfig> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserOauthConfig> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserOauthConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}