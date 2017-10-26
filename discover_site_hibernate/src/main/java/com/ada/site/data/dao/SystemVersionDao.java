package com.ada.site.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.site.data.entity.SystemVersion;

/**
* Created by imake on 2017年08月15日13:28:19.
*/
public interface SystemVersionDao extends BaseDao<SystemVersion,Long>{

	 SystemVersion findById(Long id);

	 SystemVersion save(SystemVersion bean);

	 SystemVersion updateByUpdater(Updater<SystemVersion> updater);

	 SystemVersion deleteById(Long id);

	Long next(String sequence);

}