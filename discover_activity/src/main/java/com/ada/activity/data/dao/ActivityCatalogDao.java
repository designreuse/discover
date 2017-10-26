package com.ada.activity.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.activity.data.entity.ActivityCatalog;

/**
* Created by imake on 2017年08月15日09:57:56.
*/
public interface ActivityCatalogDao extends BaseDao<ActivityCatalog,Integer>{

	 ActivityCatalog findById(Integer id);

	 ActivityCatalog save(ActivityCatalog bean);

	 ActivityCatalog updateByUpdater(Updater<ActivityCatalog> updater);

	 ActivityCatalog deleteById(Integer id);
}