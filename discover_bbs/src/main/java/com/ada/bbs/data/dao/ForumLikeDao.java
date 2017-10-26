package com.ada.bbs.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.ForumLike;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
public interface ForumLikeDao extends BaseDao<ForumLike,Long>{

	public ForumLike findById(Long id);

	public ForumLike save(ForumLike bean);

	public ForumLike updateByUpdater(Updater<ForumLike> updater);

	public ForumLike deleteById(Long id);
}