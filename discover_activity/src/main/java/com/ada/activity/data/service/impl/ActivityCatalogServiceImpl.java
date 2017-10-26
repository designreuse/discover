package com.ada.activity.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.activity.data.dao.ActivityCatalogDao;
import com.ada.activity.data.entity.ActivityCatalog;
import com.ada.activity.data.service.ActivityCatalogService;

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
public class ActivityCatalogServiceImpl implements ActivityCatalogService {

	private ActivityCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public ActivityCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<ActivityCatalog> findByTops(Integer pid) {
		LinkedList<ActivityCatalog> result = new LinkedList<ActivityCatalog>();
		ActivityCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}

	@Override
    @Transactional
	public ActivityCatalog save(ActivityCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ActivityCatalog update(ActivityCatalog bean) {
		Updater<ActivityCatalog> updater = new Updater<ActivityCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ActivityCatalog[] deleteByIds(Integer[] ids) {
		ActivityCatalog[] beans = new ActivityCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ActivityCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ActivityCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ActivityCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ActivityCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}