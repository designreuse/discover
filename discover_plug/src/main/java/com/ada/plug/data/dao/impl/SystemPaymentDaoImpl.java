package com.ada.plug.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.plug.data.dao.SystemPaymentDao;
import com.ada.plug.data.entity.SystemPayment;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
@Repository

public class SystemPaymentDaoImpl extends CriteriaDaoImpl<SystemPayment, Long> implements SystemPaymentDao {

	@Override
	public SystemPayment findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public SystemPayment save(SystemPayment bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public SystemPayment deleteById(Long id) {
		SystemPayment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SystemPayment> getEntityClass() {
		return SystemPayment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}