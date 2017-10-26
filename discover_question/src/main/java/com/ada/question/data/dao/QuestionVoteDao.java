package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionVote;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionVoteDao extends BaseDao<QuestionVote,Long>{

	 QuestionVote findById(Long id);

	 QuestionVote save(QuestionVote bean);

	 QuestionVote updateByUpdater(Updater<QuestionVote> updater);

	 QuestionVote deleteById(Long id);
}