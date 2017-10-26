package com.ada.bbs.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.ForumPost;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostDao extends CriteriaDao<ForumPost,Long>{

	public ForumPost findById(Long id);

	public ForumPost save(ForumPost bean);

	public ForumPost updateByUpdater(Updater<ForumPost> updater);

	public ForumPost deleteById(Long id);
}