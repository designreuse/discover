package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserLoginLog;

/**
* Created by imake on 2017年07月21日15:55:36.
*/
public interface UserLoginLogDao extends BaseDao<UserLoginLog,Long>{

	public UserLoginLog findById(Long id);

	public UserLoginLog save(UserLoginLog bean);

	public UserLoginLog updateByUpdater(Updater<UserLoginLog> updater);

	public UserLoginLog deleteById(Long id);
}