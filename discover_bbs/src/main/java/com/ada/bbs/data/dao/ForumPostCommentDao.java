package com.ada.bbs.data.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.bbs.data.entity.ForumPostComment;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostCommentDao extends CriteriaDao<ForumPostComment,Long>{

	public ForumPostComment findById(Long id);

	public ForumPostComment save(ForumPostComment bean);

	public ForumPostComment updateByUpdater(Updater<ForumPostComment> updater);

	public ForumPostComment deleteById(Long id);
}