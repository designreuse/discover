package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserInfo;

/**
* Created by imake on 2017年07月20日16:35:48.
*/
public interface UserInfoDao extends BaseDao<UserInfo,Long>{

	public UserInfo findById(Long id);

	public UserInfo save(UserInfo bean);

	public UserInfo updateByUpdater(Updater<UserInfo> updater);

	public UserInfo deleteById(Long id);
}