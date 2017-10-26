package com.ada.article.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.article.data.dao.SensitiveCategoryDao;
import com.ada.article.data.entity.SensitiveCategory;
import com.ada.article.data.service.SensitiveCategoryService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日09:52:13.
*/


@Scope("prototype")
@Service
@Transactional
public class SensitiveCategoryServiceImpl implements SensitiveCategoryService {

	private SensitiveCategoryDao dao;


	@Override
	@Transactional(readOnly = true)
	public SensitiveCategory findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<SensitiveCategory> findByTops(Integer pid) {
		LinkedList<SensitiveCategory> result = new LinkedList<SensitiveCategory>();
		SensitiveCategory catalog = dao.findById(pid);
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
	public SensitiveCategory save(SensitiveCategory bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public SensitiveCategory update(SensitiveCategory bean) {
		Updater<SensitiveCategory> updater = new Updater<SensitiveCategory>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public SensitiveCategory deleteById(Integer id) {
		SensitiveCategory bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public SensitiveCategory[] deleteByIds(Integer[] ids) {
		SensitiveCategory[] beans = new SensitiveCategory[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(SensitiveCategoryDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<SensitiveCategory> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<SensitiveCategory> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<SensitiveCategory> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}