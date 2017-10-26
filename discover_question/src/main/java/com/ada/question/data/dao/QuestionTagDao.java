package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionTag;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionTagDao extends BaseDao<QuestionTag,Long>{

	 QuestionTag findById(Long id);

	 QuestionTag save(QuestionTag bean);

	 QuestionTag updateByUpdater(Updater<QuestionTag> updater);

	 QuestionTag deleteById(Long id);
}