package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserOauthConfig;
import com.ada.user.oauth.api.OauthHander;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
public interface UserOauthConfigDao extends BaseDao<UserOauthConfig,Long>{

	public UserOauthConfig findById(Long id);

	public UserOauthConfig save(UserOauthConfig bean);

	public UserOauthConfig updateByUpdater(Updater<UserOauthConfig> updater);

	public UserOauthConfig deleteById(Long id);


	OauthHander id(String model);


}