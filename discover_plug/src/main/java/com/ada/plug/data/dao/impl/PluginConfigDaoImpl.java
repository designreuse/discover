package com.ada.plug.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.plug.data.dao.PluginConfigDao;
import com.ada.plug.data.entity.PluginConfig;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
@Repository

public class PluginConfigDaoImpl extends CriteriaDaoImpl<PluginConfig, Long> implements PluginConfigDao {

	@Override
	public PluginConfig findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public PluginConfig save(PluginConfig bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public PluginConfig deleteById(Long id) {
		PluginConfig entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PluginConfig> getEntityClass() {
		return PluginConfig.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}