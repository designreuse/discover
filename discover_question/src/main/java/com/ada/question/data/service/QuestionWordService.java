package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionWord;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionWordService {

	QuestionWord findById(Long id);

	QuestionWord save(QuestionWord bean);

	QuestionWord update(QuestionWord bean);

	QuestionWord deleteById(Long id);
	
	QuestionWord[] deleteByIds(Long[] ids);
	
	Page<QuestionWord> page(Pageable pageable);
	
	Page<QuestionWord> page(Pageable pageable, Object search);


	List<QuestionWord> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}