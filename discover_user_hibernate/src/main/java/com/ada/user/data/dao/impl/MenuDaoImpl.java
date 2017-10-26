package com.ada.user.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.MenuDao;
import com.ada.user.data.entity.Menu;
import com.ada.data.core.CatalogDaoImpl;

/**
* Created by imake on 2017年07月21日14:37:30.
*/
@Repository

public class MenuDaoImpl extends CatalogDaoImpl<Menu, Integer> implements MenuDao {

	@Override
	public Menu findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Menu save(Menu bean) {

		add(bean);
		
		
		return bean;
	}

    @Override
	public Menu deleteById(Integer id) {
		Menu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Menu> getEntityClass() {
		return Menu.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}