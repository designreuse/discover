package com.ada.quartz.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.quartz.data.dao.CronTaskRecordDao;
import com.ada.quartz.data.entity.CronTaskRecord;

/**
* Created by imake on 2017年08月24日14:40:18.
*/
@Repository

public class CronTaskRecordDaoImpl extends CriteriaDaoImpl<CronTaskRecord, Long> implements CronTaskRecordDao {

	@Override
	public CronTaskRecord findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public CronTaskRecord save(CronTaskRecord bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public CronTaskRecord deleteById(Long id) {
		CronTaskRecord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CronTaskRecord> getEntityClass() {
		return CronTaskRecord.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}