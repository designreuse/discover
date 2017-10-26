package com.ada.user.data.dao.impl;

import com.ada.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserOauthTokenDao;
import com.ada.user.data.entity.UserOauthToken;

/**
 * Created by imake on 2017年07月21日16:04:29.
 */
@Repository

public class UserOauthTokenDaoImpl extends CriteriaDaoImpl<UserOauthToken, Long> implements UserOauthTokenDao {

    @Override
    public UserOauthToken findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public UserOauthToken findByUser(Long user, String type) {
        Finder finder = Finder.create();
        finder.append("from UserOauthToken u where u.user.id=:user and u.token_type=:token_type");
        finder.setParam("user",user);
        finder.setParam("token_type",type);
        return findOne(finder);
    }

    @Override
    public UserOauthToken save(UserOauthToken bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public UserOauthToken deleteById(Long id) {
        UserOauthToken entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<UserOauthToken> getEntityClass() {
        return UserOauthToken.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}