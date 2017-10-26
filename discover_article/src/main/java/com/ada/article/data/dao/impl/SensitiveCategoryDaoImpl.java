package com.ada.article.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.data.dao.SensitiveCategoryDao;
import com.ada.article.data.entity.SensitiveCategory;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
@Repository

public class SensitiveCategoryDaoImpl extends CatalogDaoImpl<SensitiveCategory, Integer> implements SensitiveCategoryDao {

	@Override
	public SensitiveCategory findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public SensitiveCategory save(SensitiveCategory bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public SensitiveCategory deleteById(Integer id) {
		SensitiveCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SensitiveCategory> getEntityClass() {
		return SensitiveCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}