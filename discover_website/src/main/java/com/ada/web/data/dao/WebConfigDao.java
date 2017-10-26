package com.ada.web.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.web.data.entity.WebConfig;

/**
* Created by imake on 2017年08月30日09:46:28.
*/
public interface WebConfigDao extends BaseDao<WebConfig,Long>{

	 WebConfig findById(Long id);

	 WebConfig save(WebConfig bean);

	 WebConfig updateByUpdater(Updater<WebConfig> updater);

	 WebConfig deleteById(Long id);
}