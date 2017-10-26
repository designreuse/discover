package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserRoleCatalog;

/**
* Created by imake on 2017年08月09日13:36:13.
*/
public interface UserRoleCatalogDao extends BaseDao<UserRoleCatalog,Integer>{

	 UserRoleCatalog findById(Integer id);

	 UserRoleCatalog save(UserRoleCatalog bean);

	 UserRoleCatalog updateByUpdater(Updater<UserRoleCatalog> updater);

	 UserRoleCatalog deleteById(Integer id);
}