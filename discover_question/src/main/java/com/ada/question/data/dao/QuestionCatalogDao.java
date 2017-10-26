package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionCatalog;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionCatalogDao extends BaseDao<QuestionCatalog,Integer>{

	 QuestionCatalog findById(Integer id);

	 QuestionCatalog save(QuestionCatalog bean);

	 QuestionCatalog updateByUpdater(Updater<QuestionCatalog> updater);

	 QuestionCatalog deleteById(Integer id);
}