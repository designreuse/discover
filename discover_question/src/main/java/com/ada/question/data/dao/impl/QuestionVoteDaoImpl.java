package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionVoteDao;
import com.ada.question.data.entity.QuestionVote;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
@Repository

public class QuestionVoteDaoImpl extends CriteriaDaoImpl<QuestionVote, Long> implements QuestionVoteDao {

	@Override
	public QuestionVote findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionVote save(QuestionVote bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionVote deleteById(Long id) {
		QuestionVote entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionVote> getEntityClass() {
		return QuestionVote.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}