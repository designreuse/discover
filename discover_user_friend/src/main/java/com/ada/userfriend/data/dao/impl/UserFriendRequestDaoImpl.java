package com.ada.userfriend.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.userfriend.data.dao.UserFriendRequestDao;
import com.ada.userfriend.data.entity.UserFriendRequest;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
@Repository

public class UserFriendRequestDaoImpl extends CriteriaDaoImpl<UserFriendRequest, Long> implements UserFriendRequestDao {

	@Override
	public UserFriendRequest findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserFriendRequest save(UserFriendRequest bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserFriendRequest deleteById(Long id) {
		UserFriendRequest entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFriendRequest> getEntityClass() {
		return UserFriendRequest.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}