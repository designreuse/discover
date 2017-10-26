package com.ada.quartz.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.quartz.data.dao.CronTaskDao;
import com.ada.quartz.data.entity.CronTask;
import com.ada.quartz.data.service.CronTaskService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月24日14:31:27.
*/


@Scope("prototype")
@Service
@Transactional
public class CronTaskServiceImpl implements CronTaskService {

	private CronTaskDao dao;


	@Override
	@Transactional(readOnly = true)
	public CronTask findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public CronTask save(CronTask bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public CronTask update(CronTask bean) {
		Updater<CronTask> updater = new Updater<CronTask>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public CronTask deleteById(Long id) {
		CronTask bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public CronTask[] deleteByIds(Long[] ids) {
		CronTask[] beans = new CronTask[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CronTaskDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<CronTask> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<CronTask> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<CronTask> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}