package com.ada.bbs.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.bbs.data.dao.ForumPostDao;
import com.ada.bbs.data.entity.ForumPost;


/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Repository
public class ForumPostDaoImpl extends CriteriaDaoImpl<ForumPost, Long> implements ForumPostDao {

	@Override
	public ForumPost findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ForumPost save(ForumPost bean) {
		getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ForumPost deleteById(Long id) {
		ForumPost entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ForumPost> getEntityClass() {
		return ForumPost.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}