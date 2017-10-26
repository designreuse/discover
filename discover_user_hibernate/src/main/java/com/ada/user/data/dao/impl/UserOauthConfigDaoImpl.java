package com.ada.user.data.dao.impl;

import com.ada.data.core.Finder;
import com.ada.user.oauth.api.OauthHander;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserOauthConfigDao;
import com.ada.user.data.entity.UserOauthConfig;

import java.util.HashMap;

/**
 * Created by imake on 2017年07月20日17:47:47.
 */
@Repository

public class UserOauthConfigDaoImpl extends CriteriaDaoImpl<UserOauthConfig, Long> implements UserOauthConfigDao {

    private static HashMap<String, OauthHander> handers = new HashMap<String, OauthHander>();

    @Override
    public UserOauthConfig findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public UserOauthConfig save(UserOauthConfig bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public UserOauthConfig deleteById(Long id) {
        UserOauthConfig entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    public OauthHander id(String model) {
        OauthHander result = null;
        result = handers.get(model);
        if (result == null) {
            Finder finder = Finder.create();
            finder.append("from UserOauthConfig u where u.model=:model");
            finder.setParam("model", model);
            UserOauthConfig config = findOne(finder);
            if (config == null) {
                return null;
            }
            try {
                Class c = Class.forName(config.getClassName());
                result = (OauthHander) c.newInstance();
                result.setKey(config.getAppKey());
                result.setSecret(config.getAppSecret());
                handers.put(model, result);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    protected Class<UserOauthConfig> getEntityClass() {
        return UserOauthConfig.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}