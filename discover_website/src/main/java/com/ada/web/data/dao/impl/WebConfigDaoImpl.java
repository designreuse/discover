package com.ada.web.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.web.data.dao.WebConfigDao;
import com.ada.web.data.entity.WebConfig;

/**
* Created by imake on 2017年08月30日09:46:28.
*/
@Repository

public class WebConfigDaoImpl extends CriteriaDaoImpl<WebConfig, Long> implements WebConfigDao {

	@Override
	public WebConfig findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public WebConfig save(WebConfig bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public WebConfig deleteById(Long id) {
		WebConfig entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<WebConfig> getEntityClass() {
		return WebConfig.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}