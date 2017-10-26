package com.ada.site.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.site.data.entity.LinkType;

/**
* Created by imake on 2017年08月28日16:29:13.
*/
public interface LinkTypeDao extends BaseDao<LinkType,Integer>{

	 LinkType findById(Integer id);

	 LinkType save(LinkType bean);

	 LinkType updateByUpdater(Updater<LinkType> updater);

	 LinkType deleteById(Integer id);
}