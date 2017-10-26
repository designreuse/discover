package com.ada.bbs.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.bbs.data.dao.ForumDao;
import com.ada.bbs.data.entity.Forum;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
@Repository

public class ForumDaoImpl extends CatalogDaoImpl<Forum, Integer> implements ForumDao {

	@Override
	public Forum findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Forum save(Forum bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public Forum deleteById(Integer id) {
		Forum entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Forum> getEntityClass() {
		return Forum.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}