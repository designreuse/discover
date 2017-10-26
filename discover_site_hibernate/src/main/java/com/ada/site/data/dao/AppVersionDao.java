package com.ada.site.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.site.data.entity.AppVersion;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
public interface AppVersionDao extends BaseDao<AppVersion,Long>{

	public AppVersion findById(Long id);

	public AppVersion save(AppVersion bean);

	public AppVersion updateByUpdater(Updater<AppVersion> updater);

	public AppVersion deleteById(Long id);
}