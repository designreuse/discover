package com.ada.bbs.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.Forum;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
public interface ForumDao extends BaseDao<Forum,Integer>{

	public Forum findById(Integer id);

	public Forum save(Forum bean);

	public Forum updateByUpdater(Updater<Forum> updater);

	public Forum deleteById(Integer id);
}