package com.ada.quartz.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.quartz.data.dao.CronTaskRecordDao;
import com.ada.quartz.data.entity.CronTaskRecord;
import com.ada.quartz.data.service.CronTaskRecordService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月24日14:40:18.
*/


@Scope("prototype")
@Service
@Transactional
public class CronTaskRecordServiceImpl implements CronTaskRecordService {

	private CronTaskRecordDao dao;


	@Override
	@Transactional(readOnly = true)
	public CronTaskRecord findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public CronTaskRecord save(CronTaskRecord bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public CronTaskRecord update(CronTaskRecord bean) {
		Updater<CronTaskRecord> updater = new Updater<CronTaskRecord>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public CronTaskRecord deleteById(Long id) {
		CronTaskRecord bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public CronTaskRecord[] deleteByIds(Long[] ids) {
		CronTaskRecord[] beans = new CronTaskRecord[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CronTaskRecordDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<CronTaskRecord> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<CronTaskRecord> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<CronTaskRecord> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}