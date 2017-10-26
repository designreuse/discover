package com.ada.quartz.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.quartz.data.dao.CronTaskDao;
import com.ada.quartz.data.entity.CronTask;

/**
* Created by imake on 2017年08月24日14:31:26.
*/
@Repository

public class CronTaskDaoImpl extends CriteriaDaoImpl<CronTask, Long> implements CronTaskDao {

	@Override
	public CronTask findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CronTask save(CronTask bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CronTask deleteById(Long id) {
		CronTask entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CronTask> getEntityClass() {
		return CronTask.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}