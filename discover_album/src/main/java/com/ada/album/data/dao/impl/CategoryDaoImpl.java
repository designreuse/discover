package com.ada.album.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.album.data.dao.CategoryDao;
import com.ada.album.data.entity.Category;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
@Repository

public class CategoryDaoImpl extends CriteriaDaoImpl<Category, String> implements CategoryDao {

	@Override
	public Category findById(String id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Category save(Category bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Category deleteById(String id) {
		Category entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Category> getEntityClass() {
		return Category.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}