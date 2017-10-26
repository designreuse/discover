package com.ada.plug.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.plug.data.entity.PluginConfig;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
public interface PluginConfigDao extends BaseDao<PluginConfig,Long>{

	 PluginConfig findById(Long id);

	 PluginConfig save(PluginConfig bean);

	 PluginConfig updateByUpdater(Updater<PluginConfig> updater);

	 PluginConfig deleteById(Long id);
}