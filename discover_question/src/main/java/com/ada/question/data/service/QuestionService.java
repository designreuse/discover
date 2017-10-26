package com.ada.question.data.service;

import com.ada.question.data.entity.Question;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:23.
*/
public interface QuestionService {

	Question findById(Long id);

	Question save(Question bean);

	Question update(Question bean);

	Question deleteById(Long id);
	
	Question[] deleteByIds(Long[] ids);
	
	Page<Question> page(Pageable pageable);
	
	Page<Question> page(Pageable pageable, Object search);


	List<Question> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}