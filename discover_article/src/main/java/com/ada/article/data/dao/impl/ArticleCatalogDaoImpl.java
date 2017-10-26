package com.ada.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.data.dao.ArticleCatalogDao;
import com.ada.article.data.entity.ArticleCatalog;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
@Repository

public class ArticleCatalogDaoImpl extends CatalogDaoImpl<ArticleCatalog, Integer> implements ArticleCatalogDao {

	@Override
	public ArticleCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ArticleCatalog save(ArticleCatalog bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleCatalog> getEntityClass() {
		return ArticleCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}