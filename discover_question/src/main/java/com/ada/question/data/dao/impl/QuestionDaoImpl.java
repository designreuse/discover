package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionDao;
import com.ada.question.data.entity.Question;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
@Repository

public class QuestionDaoImpl extends CriteriaDaoImpl<Question, Long> implements QuestionDao {

	@Override
	public Question findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Question save(Question bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Question deleteById(Long id) {
		Question entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Question> getEntityClass() {
		return Question.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}