package com.ada.album.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.album.data.entity.Album;

/**
* Created by imake on 2017年08月15日10:04:54.
*/
public interface AlbumDao extends BaseDao<Album,Long>{

	 Album findById(Long id);

	 Album save(Album bean);

	 Album updateByUpdater(Updater<Album> updater);

	 Album deleteById(Long id);
}