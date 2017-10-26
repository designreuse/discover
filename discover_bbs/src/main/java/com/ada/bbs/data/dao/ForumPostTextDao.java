package com.ada.bbs.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.ForumPostText;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostTextDao extends CriteriaDao<ForumPostText,Long>{

	public ForumPostText findById(Long id);

	public ForumPostText save(ForumPostText bean);

	public ForumPostText updateByUpdater(Updater<ForumPostText> updater);

	public ForumPostText deleteById(Long id);
}