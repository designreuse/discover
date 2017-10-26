package com.ada.question.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.question.data.entity.QuestionAnswerVote;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionAnswerVoteDao extends BaseDao<QuestionAnswerVote,Long>{

	 QuestionAnswerVote findById(Long id);

	 QuestionAnswerVote save(QuestionAnswerVote bean);

	 QuestionAnswerVote updateByUpdater(Updater<QuestionAnswerVote> updater);

	 QuestionAnswerVote deleteById(Long id);
}