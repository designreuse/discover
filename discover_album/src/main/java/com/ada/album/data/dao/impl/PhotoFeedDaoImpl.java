package com.ada.album.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.album.data.dao.PhotoFeedDao;
import com.ada.album.data.entity.PhotoFeed;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
@Repository

public class PhotoFeedDaoImpl extends CriteriaDaoImpl<PhotoFeed, Long> implements PhotoFeedDao {

	@Override
	public PhotoFeed findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public PhotoFeed save(PhotoFeed bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public PhotoFeed deleteById(Long id) {
		PhotoFeed entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PhotoFeed> getEntityClass() {
		return PhotoFeed.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}