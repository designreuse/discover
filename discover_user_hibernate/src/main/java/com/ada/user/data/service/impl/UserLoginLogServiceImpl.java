package com.ada.user.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserLoginLogDao;
import com.ada.user.data.entity.UserLoginLog;
import com.ada.user.data.service.UserLoginLogService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月21日15:55:37.
*/
@Service
@Transactional
public class UserLoginLogServiceImpl implements UserLoginLogService {

	private UserLoginLogDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserLoginLog findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserLoginLog save(UserLoginLog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserLoginLog update(UserLoginLog bean) {
		Updater<UserLoginLog> updater = new Updater<UserLoginLog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserLoginLog deleteById(Long id) {
		UserLoginLog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserLoginLog[] deleteByIds(Long[] ids) {
		UserLoginLog[] beans = new UserLoginLog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserLoginLogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserLoginLog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserLoginLog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserLoginLog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}