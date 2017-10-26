package com.ada.site.data.dao.impl;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.page.Filter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.site.data.dao.AppDao;
import com.ada.site.data.entity.App;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
@Repository

public class AppDaoImpl extends BaseDaoImpl<App, Long> implements AppDao {

	@Override
	public App findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public App save(App bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public App deleteById(Long id) {
		App entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	public Long count(Filter... filters) {
		List<Filter> filterList=new ArrayList<Filter>();
		if (filters!=null){
			for (Filter filter : filters) {
				filterList.add(filter);
			}
		}
		Finder finder=makeFinder(filterList,null);
		return countQuery(finder);
	}

	@Override
	protected Class<App> getEntityClass() {
		return App.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}