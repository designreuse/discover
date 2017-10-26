package com.ada.bbs.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.bbs.data.dao.ForumLikeDao;
import com.ada.bbs.data.entity.ForumLike;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
@Repository

public class ForumLikeDaoImpl extends CriteriaDaoImpl<ForumLike, Long> implements ForumLikeDao {

	@Override
	public ForumLike findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ForumLike save(ForumLike bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ForumLike deleteById(Long id) {
		ForumLike entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ForumLike> getEntityClass() {
		return ForumLike.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}