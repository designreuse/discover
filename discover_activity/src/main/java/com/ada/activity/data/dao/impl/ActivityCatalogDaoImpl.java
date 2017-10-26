package com.ada.activity.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.activity.data.dao.ActivityCatalogDao;
import com.ada.activity.data.entity.ActivityCatalog;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月15日09:57:56.
*/
@Repository

public class ActivityCatalogDaoImpl extends CatalogDaoImpl<ActivityCatalog, Integer> implements ActivityCatalogDao {

	@Override
	public ActivityCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ActivityCatalog save(ActivityCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public ActivityCatalog deleteById(Integer id) {
		ActivityCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ActivityCatalog> getEntityClass() {
		return ActivityCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}