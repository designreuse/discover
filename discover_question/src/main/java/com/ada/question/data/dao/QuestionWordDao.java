package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionWord;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionWordDao extends BaseDao<QuestionWord,Long>{

	 QuestionWord findById(Long id);

	 QuestionWord save(QuestionWord bean);

	 QuestionWord updateByUpdater(Updater<QuestionWord> updater);

	 QuestionWord deleteById(Long id);
}