package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserRole;

/**
* Created by imake on 2017年07月20日17:47:47.
*/
public interface UserRoleDao extends BaseDao<UserRole,Long>{

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole updateByUpdater(Updater<UserRole> updater);

	public UserRole deleteById(Long id);
}