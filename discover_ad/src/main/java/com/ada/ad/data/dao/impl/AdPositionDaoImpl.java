package com.ada.ad.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.ad.data.dao.AdPositionDao;
import com.ada.ad.data.entity.AdPosition;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年10月10日13:39:55.
*/
@Repository

public class AdPositionDaoImpl extends CatalogDaoImpl<AdPosition, Integer> implements AdPositionDao {

	@Override
	public AdPosition findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public AdPosition save(AdPosition bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public AdPosition deleteById(Integer id) {
		AdPosition entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<AdPosition> getEntityClass() {
		return AdPosition.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}