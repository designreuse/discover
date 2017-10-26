package com.ada.bbs.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.bbs.data.dao.ForumPostLikeDao;
import com.ada.bbs.data.entity.ForumPostLike;


/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Repository
public class ForumPostLikeDaoImpl extends CriteriaDaoImpl<ForumPostLike, Long> implements ForumPostLikeDao {

	@Override
	public ForumPostLike findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ForumPostLike save(ForumPostLike bean) {
		getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ForumPostLike deleteById(Long id) {
		ForumPostLike entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ForumPostLike> getEntityClass() {
		return ForumPostLike.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}