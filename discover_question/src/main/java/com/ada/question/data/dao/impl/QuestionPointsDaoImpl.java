package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionPointsDao;
import com.ada.question.data.entity.QuestionPoints;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
@Repository

public class QuestionPointsDaoImpl extends CriteriaDaoImpl<QuestionPoints, Long> implements QuestionPointsDao {

	@Override
	public QuestionPoints findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionPoints save(QuestionPoints bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionPoints deleteById(Long id) {
		QuestionPoints entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionPoints> getEntityClass() {
		return QuestionPoints.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}