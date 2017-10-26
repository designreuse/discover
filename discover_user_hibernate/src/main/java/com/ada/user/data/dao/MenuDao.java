package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.Menu;

/**
* Created by imake on 2017年07月21日14:37:30.
*/
public interface MenuDao extends BaseDao<Menu,Integer>{

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu updateByUpdater(Updater<Menu> updater);

	public Menu deleteById(Integer id);
}