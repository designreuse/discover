package com.ada.album.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.album.data.dao.TagDao;
import com.ada.album.data.entity.Tag;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
@Repository

public class TagDaoImpl extends CriteriaDaoImpl<Tag, String> implements TagDao {

	@Override
	public Tag findById(String id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Tag save(Tag bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Tag deleteById(String id) {
		Tag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Tag> getEntityClass() {
		return Tag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}