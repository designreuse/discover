package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionAnswer;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionAnswerDao extends BaseDao<QuestionAnswer,Long>{

	 QuestionAnswer findById(Long id);

	 QuestionAnswer save(QuestionAnswer bean);

	 QuestionAnswer updateByUpdater(Updater<QuestionAnswer> updater);

	 QuestionAnswer deleteById(Long id);
}