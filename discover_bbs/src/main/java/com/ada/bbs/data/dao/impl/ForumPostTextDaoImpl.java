package com.ada.bbs.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.bbs.data.dao.ForumPostTextDao;
import com.ada.bbs.data.entity.ForumPostText;


/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Repository
public class ForumPostTextDaoImpl extends CriteriaDaoImpl<ForumPostText, Long> implements ForumPostTextDao {

	@Override
	public ForumPostText findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ForumPostText save(ForumPostText bean) {
		getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ForumPostText deleteById(Long id) {
		ForumPostText entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ForumPostText> getEntityClass() {
		return ForumPostText.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}