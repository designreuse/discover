package com.ada.album.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.album.data.dao.AlbumDao;
import com.ada.album.data.entity.Album;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
@Repository

public class AlbumDaoImpl extends CriteriaDaoImpl<Album, Long> implements AlbumDao {

	@Override
	public Album findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Album save(Album bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Album deleteById(Long id) {
		Album entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Album> getEntityClass() {
		return Album.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}