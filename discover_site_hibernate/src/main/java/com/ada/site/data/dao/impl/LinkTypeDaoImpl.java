package com.ada.site.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.site.data.dao.LinkTypeDao;
import com.ada.site.data.entity.LinkType;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年08月28日16:29:13.
*/
@Repository

public class LinkTypeDaoImpl extends CatalogDaoImpl<LinkType, Integer> implements LinkTypeDao {

	@Override
	public LinkType findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public LinkType save(LinkType bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public LinkType deleteById(Integer id) {
		LinkType entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<LinkType> getEntityClass() {
		return LinkType.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}