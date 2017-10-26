package com.ada.album.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.album.data.entity.PhotoFeed;

/**
* Created by imake on 2017年08月15日10:04:55.
*/
public interface PhotoFeedDao extends BaseDao<PhotoFeed,Long>{

	 PhotoFeed findById(Long id);

	 PhotoFeed save(PhotoFeed bean);

	 PhotoFeed updateByUpdater(Updater<PhotoFeed> updater);

	 PhotoFeed deleteById(Long id);
}