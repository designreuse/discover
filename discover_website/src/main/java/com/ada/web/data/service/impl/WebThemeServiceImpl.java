package com.ada.web.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.web.data.dao.WebThemeDao;
import com.ada.web.data.entity.WebTheme;
import com.ada.web.data.service.WebThemeService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月30日10:16:29.
*/


@Scope("prototype")
@Service
@Transactional
public class WebThemeServiceImpl implements WebThemeService {

	private WebThemeDao dao;


	@Override
	@Transactional(readOnly = true)
	public WebTheme findById(String id) {
		return dao.findById(id);
	}

	@Override
	public WebTheme key(String name) {
		WebTheme theme=dao.findById(name);
		if (theme==null){
			theme=new WebTheme();
			theme.setId(name);
			dao.save(theme);
		}
		return theme;
	}


	@Override
    @Transactional
	public WebTheme save(WebTheme bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public WebTheme update(WebTheme bean) {
		Updater<WebTheme> updater = new Updater<WebTheme>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public WebTheme deleteById(String id) {
		WebTheme bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public WebTheme[] deleteByIds(String[] ids) {
		WebTheme[] beans = new WebTheme[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(WebThemeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<WebTheme> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<WebTheme> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<WebTheme> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}