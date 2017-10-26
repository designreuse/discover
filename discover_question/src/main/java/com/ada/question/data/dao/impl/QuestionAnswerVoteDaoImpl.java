package com.ada.question.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.question.data.dao.QuestionAnswerVoteDao;
import com.ada.question.data.entity.QuestionAnswerVote;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
@Repository

public class QuestionAnswerVoteDaoImpl extends CriteriaDaoImpl<QuestionAnswerVote, Long> implements QuestionAnswerVoteDao {

	@Override
	public QuestionAnswerVote findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionAnswerVote save(QuestionAnswerVote bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public QuestionAnswerVote deleteById(Long id) {
		QuestionAnswerVote entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionAnswerVote> getEntityClass() {
		return QuestionAnswerVote.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}