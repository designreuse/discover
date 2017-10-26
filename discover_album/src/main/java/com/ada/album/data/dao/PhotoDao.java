package com.ada.album.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.album.data.entity.Photo;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface PhotoDao extends BaseDao<Photo,String>{

	 Photo findById(String id);

	 Photo save(Photo bean);

	 Photo updateByUpdater(Updater<Photo> updater);

	 Photo deleteById(String id);
}