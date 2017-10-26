package com.ada.activity.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.activity.data.entity.Activity;

/**
* Created by imake on 2017年08月15日09:57:55.
*/
public interface ActivityDao extends BaseDao<Activity,Long>{

	 Activity findById(Long id);

	 Activity save(Activity bean);

	 Activity updateByUpdater(Updater<Activity> updater);

	 Activity deleteById(Long id);
}