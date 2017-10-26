package com.ada.user.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserLoginLogDao;
import com.ada.user.data.entity.UserLoginLog;

/**
* Created by imake on 2017年07月21日15:55:37.
*/
@Repository

public class UserLoginLogDaoImpl extends CriteriaDaoImpl<UserLoginLog, Long> implements UserLoginLogDao {

	@Override
	public UserLoginLog findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserLoginLog save(UserLoginLog bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserLoginLog deleteById(Long id) {
		UserLoginLog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserLoginLog> getEntityClass() {
		return UserLoginLog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}