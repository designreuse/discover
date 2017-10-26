package com.ada.userfriend.data.dao.impl;

import com.ada.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.userfriend.data.dao.UserFollowDao;
import com.ada.userfriend.data.entity.UserFollow;

import java.util.List;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
@Repository

public class UserFollowDaoImpl extends CriteriaDaoImpl<UserFollow, Long> implements UserFollowDao {

	@Override
	public UserFollow findById(Long id, Long friendid) {
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.user.id =:uid");
		finder.setParam("uid", id);
		finder.append("  and u.follower.id =:fid");
		finder.setParam("fid", friendid);
		return findOne(finder);
	}

	@Override
	public UserFollow findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserFollow save(UserFollow bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserFollow deleteById(Long id) {
		UserFollow entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFollow> getEntityClass() {
		return UserFollow.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}