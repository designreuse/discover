package com.ada.bbs.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.ForumPostLike;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostLikeDao extends CriteriaDao<ForumPostLike,Long>{

	public ForumPostLike findById(Long id);

	public ForumPostLike save(ForumPostLike bean);

	public ForumPostLike updateByUpdater(Updater<ForumPostLike> updater);

	public ForumPostLike deleteById(Long id);
}