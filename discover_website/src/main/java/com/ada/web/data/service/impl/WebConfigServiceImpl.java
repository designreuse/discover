package com.ada.web.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.web.data.dao.WebConfigDao;
import com.ada.web.data.entity.WebConfig;
import com.ada.web.data.service.WebConfigService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月30日09:46:28.
*/


@Scope("prototype")
@Service
@Transactional
public class WebConfigServiceImpl implements WebConfigService {

	private WebConfigDao dao;


	@Override
	@Transactional(readOnly = true)
	public WebConfig findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public WebConfig save(WebConfig bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public WebConfig update(WebConfig bean) {
		Updater<WebConfig> updater = new Updater<WebConfig>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public WebConfig deleteById(Long id) {
		WebConfig bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public WebConfig[] deleteByIds(Long[] ids) {
		WebConfig[] beans = new WebConfig[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(WebConfigDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<WebConfig> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<WebConfig> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<WebConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}