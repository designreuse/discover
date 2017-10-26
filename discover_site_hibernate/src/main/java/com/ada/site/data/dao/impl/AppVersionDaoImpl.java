package com.ada.site.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.site.data.dao.AppVersionDao;
import com.ada.site.data.entity.AppVersion;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
@Repository

public class AppVersionDaoImpl extends CriteriaDaoImpl<AppVersion, Long> implements AppVersionDao {

	@Override
	public AppVersion findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public AppVersion save(AppVersion bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public AppVersion deleteById(Long id) {
		AppVersion entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<AppVersion> getEntityClass() {
		return AppVersion.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}