package com.ada.activity.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.activity.data.dao.ActivityDao;
import com.ada.activity.data.entity.Activity;
import com.ada.activity.data.service.ActivityService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日09:57:56.
*/


@Scope("prototype")
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	private ActivityDao dao;


	@Override
	@Transactional(readOnly = true)
	public Activity findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Activity save(Activity bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Activity update(Activity bean) {
		Updater<Activity> updater = new Updater<Activity>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Activity deleteById(Long id) {
		Activity bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Activity[] deleteByIds(Long[] ids) {
		Activity[] beans = new Activity[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ActivityDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Activity> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Activity> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Activity> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}