package com.ada.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.data.dao.SensitiveWordDao;
import com.ada.article.data.entity.SensitiveWord;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
@Repository

public class SensitiveWordDaoImpl extends CriteriaDaoImpl<SensitiveWord, Long> implements SensitiveWordDao {

	@Override
	public SensitiveWord findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public SensitiveWord save(SensitiveWord bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public SensitiveWord deleteById(Long id) {
		SensitiveWord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SensitiveWord> getEntityClass() {
		return SensitiveWord.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}