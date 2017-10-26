package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionCatalogDao;
import com.ada.question.data.entity.QuestionCatalog;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
@Repository

public class QuestionCatalogDaoImpl extends CatalogDaoImpl<QuestionCatalog, Integer> implements QuestionCatalogDao {

	@Override
	public QuestionCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionCatalog save(QuestionCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public QuestionCatalog deleteById(Integer id) {
		QuestionCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionCatalog> getEntityClass() {
		return QuestionCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}