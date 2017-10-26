package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionVote;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionVoteService {

	QuestionVote findById(Long id);

	QuestionVote save(QuestionVote bean);

	QuestionVote update(QuestionVote bean);

	QuestionVote deleteById(Long id);
	
	QuestionVote[] deleteByIds(Long[] ids);
	
	Page<QuestionVote> page(Pageable pageable);
	
	Page<QuestionVote> page(Pageable pageable, Object search);


	List<QuestionVote> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}