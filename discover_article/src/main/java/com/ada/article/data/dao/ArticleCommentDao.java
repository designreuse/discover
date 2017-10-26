package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.ArticleComment;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface ArticleCommentDao extends BaseDao<ArticleComment,Long>{

	 ArticleComment findById(Long id);

	 ArticleComment save(ArticleComment bean);

	 ArticleComment updateByUpdater(Updater<ArticleComment> updater);

	 ArticleComment deleteById(Long id);
}