package com.ada.user.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserInfoDao;
import com.ada.user.data.entity.UserInfo;

/**
* Created by imake on 2017年07月20日16:35:48.
*/
@Repository

public class UserInfoDaoImpl extends CriteriaDaoImpl<UserInfo, Long> implements UserInfoDao {

	@Override
	public UserInfo findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserInfo save(UserInfo bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserInfo deleteById(Long id) {
		UserInfo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserInfo> getEntityClass() {
		return UserInfo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}