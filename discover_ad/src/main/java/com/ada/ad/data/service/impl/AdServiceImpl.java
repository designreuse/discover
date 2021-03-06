package com.ada.ad.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.ad.data.dao.AdDao;
import com.ada.ad.data.entity.Ad;
import com.ada.ad.data.service.AdService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年10月10日12:04:43.
*/


@Scope("prototype")
@Service
@Transactional
public class AdServiceImpl implements AdService {

	private AdDao dao;


	@Override
	@Transactional(readOnly = true)
	public Ad findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Ad save(Ad bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Ad update(Ad bean) {
		Updater<Ad> updater = new Updater<Ad>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Ad deleteById(Long id) {
		Ad bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Ad[] deleteByIds(Long[] ids) {
		Ad[] beans = new Ad[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AdDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Ad> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Ad> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Ad> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}