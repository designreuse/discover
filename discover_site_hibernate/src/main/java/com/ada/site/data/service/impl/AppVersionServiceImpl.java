package com.ada.site.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.data.dao.AppVersionDao;
import com.ada.site.data.entity.AppVersion;
import com.ada.site.data.service.AppVersionService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月25日11:33:24.
*/
@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {

	private AppVersionDao dao;


	@Override
	@Transactional(readOnly = true)
	public AppVersion findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public AppVersion save(AppVersion bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public AppVersion update(AppVersion bean) {
		Updater<AppVersion> updater = new Updater<AppVersion>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public AppVersion deleteById(Long id) {
		AppVersion bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public AppVersion[] deleteByIds(Long[] ids) {
		AppVersion[] beans = new AppVersion[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AppVersionDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<AppVersion> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<AppVersion> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<AppVersion> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}