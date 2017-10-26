package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionAnswerVote;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionAnswerVoteService {

	QuestionAnswerVote findById(Long id);

	QuestionAnswerVote save(QuestionAnswerVote bean);

	QuestionAnswerVote update(QuestionAnswerVote bean);

	QuestionAnswerVote deleteById(Long id);
	
	QuestionAnswerVote[] deleteByIds(Long[] ids);
	
	Page<QuestionAnswerVote> page(Pageable pageable);
	
	Page<QuestionAnswerVote> page(Pageable pageable, Object search);


	List<QuestionAnswerVote> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}