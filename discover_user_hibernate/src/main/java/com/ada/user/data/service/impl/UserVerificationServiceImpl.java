package com.ada.user.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserVerificationDao;
import com.ada.user.data.entity.UserVerification;
import com.ada.user.data.service.UserVerificationService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月20日16:37:49.
*/
@Service
@Transactional
public class UserVerificationServiceImpl implements UserVerificationService {

	private UserVerificationDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserVerification findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public UserVerification save(UserVerification bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserVerification update(UserVerification bean) {
		Updater<UserVerification> updater = new Updater<UserVerification>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserVerification deleteById(Long id) {
		UserVerification bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserVerification[] deleteByIds(Long[] ids) {
		UserVerification[] beans = new UserVerification[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserVerificationDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserVerification> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserVerification> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserVerification> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}