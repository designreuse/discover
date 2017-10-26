package com.ada.user.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserRoleDao;
import com.ada.user.data.entity.UserRole;
import com.ada.user.data.service.UserRoleService;

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
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserRole findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserRole save(UserRole bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserRole update(UserRole bean) {
		Updater<UserRole> updater = new Updater<UserRole>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserRole deleteById(Long id) {
		UserRole bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserRole[] deleteByIds(Long[] ids) {
		UserRole[] beans = new UserRole[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserRoleDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserRole> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserRole> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserRole> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}