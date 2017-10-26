package com.ada.userfriend.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.userfriend.data.entity.UserFollow;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFollowDao extends BaseDao<UserFollow,Long>{


	UserFollow findById(Long id, Long friendid);

	UserFollow findById(Long id);

	 UserFollow save(UserFollow bean);

	 UserFollow updateByUpdater(Updater<UserFollow> updater);

	 UserFollow deleteById(Long id);
}