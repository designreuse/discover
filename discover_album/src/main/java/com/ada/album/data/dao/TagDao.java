package com.ada.album.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.album.data.entity.Tag;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface TagDao extends BaseDao<Tag,String>{

	 Tag findById(String id);

	 Tag save(Tag bean);

	 Tag updateByUpdater(Updater<Tag> updater);

	 Tag deleteById(String id);
}