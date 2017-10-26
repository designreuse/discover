package com.ada.userfriend.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.userfriend.data.dao.UserFriendDao;
import com.ada.userfriend.data.entity.UserFriend;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
@Repository

public class UserFriendDaoImpl extends CriteriaDaoImpl<UserFriend, Long> implements UserFriendDao {

	@Override
	public UserFriend findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserFriend save(UserFriend bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserFriend deleteById(Long id) {
		UserFriend entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFriend> getEntityClass() {
		return UserFriend.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}