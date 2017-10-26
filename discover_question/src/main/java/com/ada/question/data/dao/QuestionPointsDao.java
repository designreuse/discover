package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionPoints;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionPointsDao extends BaseDao<QuestionPoints,Long>{

	 QuestionPoints findById(Long id);

	 QuestionPoints save(QuestionPoints bean);

	 QuestionPoints updateByUpdater(Updater<QuestionPoints> updater);

	 QuestionPoints deleteById(Long id);
}