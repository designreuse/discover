package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.Article;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
public interface ArticleDao extends BaseDao<Article,Long>{

	 Article findById(Long id);

	 Article save(Article bean);

	 Article updateByUpdater(Updater<Article> updater);

	 Article deleteById(Long id);
}