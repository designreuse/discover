package com.ada.web.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.web.data.dao.WebThemeDao;
import com.ada.web.data.entity.WebTheme;

/**
* Created by imake on 2017年08月30日10:16:29.
*/
@Repository

public class WebThemeDaoImpl extends CriteriaDaoImpl<WebTheme, String> implements WebThemeDao {

	@Override
	public WebTheme findById(String id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public WebTheme save(WebTheme bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public WebTheme deleteById(String id) {
		WebTheme entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<WebTheme> getEntityClass() {
		return WebTheme.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}