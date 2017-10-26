package com.ada.user.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserRoleDao;
import com.ada.user.data.entity.UserRole;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
@Repository

public class UserRoleDaoImpl extends CriteriaDaoImpl<UserRole, Long> implements UserRoleDao {

	@Override
	public UserRole findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserRole save(UserRole bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserRole deleteById(Long id) {
		UserRole entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserRole> getEntityClass() {
		return UserRole.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}