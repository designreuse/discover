package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionTagDao;
import com.ada.question.data.entity.QuestionTag;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
@Repository

public class QuestionTagDaoImpl extends CriteriaDaoImpl<QuestionTag, Long> implements QuestionTagDao {

	@Override
	public QuestionTag findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionTag save(QuestionTag bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionTag deleteById(Long id) {
		QuestionTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionTag> getEntityClass() {
		return QuestionTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}