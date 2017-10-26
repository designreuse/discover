package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionFavorite;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionFavoriteDao extends BaseDao<QuestionFavorite,Long>{

	 QuestionFavorite findById(Long id);

	 QuestionFavorite save(QuestionFavorite bean);

	 QuestionFavorite updateByUpdater(Updater<QuestionFavorite> updater);

	 QuestionFavorite deleteById(Long id);
}