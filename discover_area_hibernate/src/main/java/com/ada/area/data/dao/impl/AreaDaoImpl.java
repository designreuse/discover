package com.ada.area.data.dao.impl;

import com.ada.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.data.core.CatalogDaoImpl;

import java.util.List;

/**
* Created by imake on 2017年08月04日10:01:33.
*/
@Repository

public class AreaDaoImpl extends CatalogDaoImpl<Area, Integer> implements AreaDao {

	@Override
	public Area findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Area save(Area bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public Area deleteById(Integer id) {
		Area entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	public Area findByName(String name) {
		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.name=:name");
		finder.setParam("name", name);
		finder.setMaxResults(2);
		return findOne(finder);
	}

	@Override
	protected Class<Area> getEntityClass() {
		return Area.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}