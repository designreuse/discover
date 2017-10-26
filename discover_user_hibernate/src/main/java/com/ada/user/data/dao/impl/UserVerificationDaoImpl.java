package com.ada.user.data.dao.impl;

import com.ada.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserVerificationDao;
import com.ada.user.data.entity.UserVerification;

/**
* Created by imake on 2017年07月20日16:37:49.
*/
@Repository

public class UserVerificationDaoImpl extends CriteriaDaoImpl<UserVerification, Long> implements UserVerificationDao {

	@Override
	public UserVerification findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public UserVerification save(UserVerification bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public UserVerification deleteById(Long id) {
		UserVerification entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserVerification> getEntityClass() {
		return UserVerification.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserVerification findByName(String phone, Integer catalog) {
		Finder finder=Finder.create();
		finder.append("from UserVerification u where u.name =:name ");
		finder.setParam("name", phone);
		finder.append(" and u.catalog =:catalog ");
		finder.setParam("catalog", catalog);
		return findOne(finder);
	}


}