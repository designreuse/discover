package com.ada.site.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.site.data.dao.LinkDao;
import com.ada.site.data.entity.Link;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
@Repository

public class LinkDaoImpl extends CriteriaDaoImpl<Link, Long> implements LinkDao {

	@Override
	public Link findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Link save(Link bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Link deleteById(Long id) {
		Link entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Link> getEntityClass() {
		return Link.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}