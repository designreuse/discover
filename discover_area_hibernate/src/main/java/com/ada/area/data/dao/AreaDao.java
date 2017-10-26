package com.ada.area.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.area.data.entity.Area;

/**
* Created by imake on 2017年08月04日10:01:33.
*/
public interface AreaDao extends BaseDao<Area,Integer>{

	public Area findById(Integer id);

	public Area save(Area bean);

	public Area updateByUpdater(Updater<Area> updater);

	public Area deleteById(Integer id);

	Area findByName(String name);

}