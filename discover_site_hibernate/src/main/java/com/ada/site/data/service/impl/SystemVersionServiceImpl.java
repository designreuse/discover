package com.ada.site.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.data.dao.SystemVersionDao;
import com.ada.site.data.entity.SystemVersion;
import com.ada.site.data.service.SystemVersionService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日13:28:19.
*/


@Scope("prototype")
@Service
@Transactional
public class SystemVersionServiceImpl implements SystemVersionService {

	private SystemVersionDao dao;


	@Override
	@Transactional(readOnly = true)
	public SystemVersion findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public SystemVersion save(SystemVersion bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public SystemVersion update(SystemVersion bean) {
		Updater<SystemVersion> updater = new Updater<SystemVersion>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public SystemVersion deleteById(Long id) {
		SystemVersion bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public SystemVersion[] deleteByIds(Long[] ids) {
		SystemVersion[] beans = new SystemVersion[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SystemVersionDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<SystemVersion> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<SystemVersion> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<SystemVersion> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}