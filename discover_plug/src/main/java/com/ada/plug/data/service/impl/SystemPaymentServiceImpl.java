package com.ada.plug.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.plug.data.dao.SystemPaymentDao;
import com.ada.plug.data.entity.SystemPayment;
import com.ada.plug.data.service.SystemPaymentService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日11:13:49.
*/


@Scope("prototype")
@Service
@Transactional
public class SystemPaymentServiceImpl implements SystemPaymentService {

	private SystemPaymentDao dao;


	@Override
	@Transactional(readOnly = true)
	public SystemPayment findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public SystemPayment save(SystemPayment bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public SystemPayment update(SystemPayment bean) {
		Updater<SystemPayment> updater = new Updater<SystemPayment>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public SystemPayment deleteById(Long id) {
		SystemPayment bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public SystemPayment[] deleteByIds(Long[] ids) {
		SystemPayment[] beans = new SystemPayment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SystemPaymentDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<SystemPayment> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<SystemPayment> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<SystemPayment> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}