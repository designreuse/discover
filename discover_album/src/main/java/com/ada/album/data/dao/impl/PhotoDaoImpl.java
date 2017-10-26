package com.ada.album.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.album.data.dao.PhotoDao;
import com.ada.album.data.entity.Photo;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
@Repository

public class PhotoDaoImpl extends CriteriaDaoImpl<Photo, String> implements PhotoDao {

	@Override
	public Photo findById(String id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Photo save(Photo bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Photo deleteById(String id) {
		Photo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Photo> getEntityClass() {
		return Photo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}