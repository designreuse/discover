package com.ada.userfriend.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.userfriend.data.entity.UserFriendRequest;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFriendRequestDao extends BaseDao<UserFriendRequest,Long>{

	 UserFriendRequest findById(Long id);

	 UserFriendRequest save(UserFriendRequest bean);

	 UserFriendRequest updateByUpdater(Updater<UserFriendRequest> updater);

	 UserFriendRequest deleteById(Long id);
}