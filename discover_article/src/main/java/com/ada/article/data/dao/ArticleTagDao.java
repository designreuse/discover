package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.ArticleTag;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface ArticleTagDao extends BaseDao<ArticleTag,Long>{

	 ArticleTag findById(Long id);

	 ArticleTag save(ArticleTag bean);

	 ArticleTag updateByUpdater(Updater<ArticleTag> updater);

	 ArticleTag deleteById(Long id);
}