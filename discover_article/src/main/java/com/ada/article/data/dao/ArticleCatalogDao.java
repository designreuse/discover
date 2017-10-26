package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.ArticleCatalog;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
public interface ArticleCatalogDao extends BaseDao<ArticleCatalog,Integer>{

	 ArticleCatalog findById(Integer id);

	 ArticleCatalog save(ArticleCatalog bean);

	 ArticleCatalog updateByUpdater(Updater<ArticleCatalog> updater);

	 ArticleCatalog deleteById(Integer id);
}