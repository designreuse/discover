package com.ada.user.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserRoleCatalogDao;
import com.ada.user.data.entity.UserRoleCatalog;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月09日13:36:13.
*/
@Repository

public class UserRoleCatalogDaoImpl extends CatalogDaoImpl<UserRoleCatalog, Integer> implements UserRoleCatalogDao {

	@Override
	public UserRoleCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserRoleCatalog save(UserRoleCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public UserRoleCatalog deleteById(Integer id) {
		UserRoleCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserRoleCatalog> getEntityClass() {
		return UserRoleCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}