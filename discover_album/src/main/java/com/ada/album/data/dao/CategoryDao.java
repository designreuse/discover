package com.ada.album.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.album.data.entity.Category;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
public interface CategoryDao extends BaseDao<Category,String>{

	 Category findById(String id);

	 Category save(Category bean);

	 Category updateByUpdater(Updater<Category> updater);

	 Category deleteById(String id);
}