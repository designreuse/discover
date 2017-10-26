package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionAnswerDao;
import com.ada.question.data.entity.QuestionAnswer;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
@Repository

public class QuestionAnswerDaoImpl extends CriteriaDaoImpl<QuestionAnswer, Long> implements QuestionAnswerDao {

	@Override
	public QuestionAnswer findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionAnswer save(QuestionAnswer bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionAnswer deleteById(Long id) {
		QuestionAnswer entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionAnswer> getEntityClass() {
		return QuestionAnswer.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}