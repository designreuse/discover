package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserOauthToken;

/**
* Created by imake on 2017年07月21日16:04:29.
*/
public interface UserOauthTokenDao extends BaseDao<UserOauthToken,Long>{

	public UserOauthToken findById(Long id);

	public UserOauthToken findByUser(Long user,String type);


	public UserOauthToken save(UserOauthToken bean);

	public UserOauthToken updateByUpdater(Updater<UserOauthToken> updater);

	public UserOauthToken deleteById(Long id);
}