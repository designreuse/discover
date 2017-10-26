package com.ada.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.data.dao.ArticleCommentDao;
import com.ada.article.data.entity.ArticleComment;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
@Repository

public class ArticleCommentDaoImpl extends CriteriaDaoImpl<ArticleComment, Long> implements ArticleCommentDao {

	@Override
	public ArticleComment findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ArticleComment save(ArticleComment bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ArticleComment deleteById(Long id) {
		ArticleComment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleComment> getEntityClass() {
		return ArticleComment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}