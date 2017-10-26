package com.ada.activity.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.activity.data.dao.ActivityDao;
import com.ada.activity.data.entity.Activity;

/**
* Created by imake on 2017年08月15日09:57:56.
*/
@Repository

public class ActivityDaoImpl extends CriteriaDaoImpl<Activity, Long> implements ActivityDao {

	@Override
	public Activity findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Activity save(Activity bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Activity deleteById(Long id) {
		Activity entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Activity> getEntityClass() {
		return Activity.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}