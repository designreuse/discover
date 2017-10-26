package com.ada.userfriend.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.userfriend.data.entity.UserFriend;

/**
* Created by imake on 2017年09月01日10:05:18.
*/
public interface UserFriendDao extends BaseDao<UserFriend,Long>{

	 UserFriend findById(Long id);

	 UserFriend save(UserFriend bean);

	 UserFriend updateByUpdater(Updater<UserFriend> updater);

	 UserFriend deleteById(Long id);
}