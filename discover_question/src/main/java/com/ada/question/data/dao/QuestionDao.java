package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.Question;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionDao extends BaseDao<Question,Long>{

	 Question findById(Long id);

	 Question save(Question bean);

	 Question updateByUpdater(Updater<Question> updater);

	 Question deleteById(Long id);
}