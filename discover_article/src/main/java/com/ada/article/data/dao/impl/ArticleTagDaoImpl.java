package com.ada.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.data.dao.ArticleTagDao;
import com.ada.article.data.entity.ArticleTag;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
@Repository

public class ArticleTagDaoImpl extends CriteriaDaoImpl<ArticleTag, Long> implements ArticleTagDao {

	@Override
	public ArticleTag findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ArticleTag save(ArticleTag bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public ArticleTag deleteById(Long id) {
		ArticleTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleTag> getEntityClass() {
		return ArticleTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}