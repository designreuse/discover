package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionWordDao;
import com.ada.question.data.entity.QuestionWord;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
@Repository

public class QuestionWordDaoImpl extends CriteriaDaoImpl<QuestionWord, Long> implements QuestionWordDao {

	@Override
	public QuestionWord findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionWord save(QuestionWord bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionWord deleteById(Long id) {
		QuestionWord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionWord> getEntityClass() {
		return QuestionWord.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}