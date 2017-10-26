package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionAnswer;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionAnswerService {

	QuestionAnswer findById(Long id);

	QuestionAnswer save(QuestionAnswer bean);

	QuestionAnswer update(QuestionAnswer bean);

	QuestionAnswer deleteById(Long id);
	
	QuestionAnswer[] deleteByIds(Long[] ids);
	
	Page<QuestionAnswer> page(Pageable pageable);
	
	Page<QuestionAnswer> page(Pageable pageable, Object search);


	List<QuestionAnswer> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}