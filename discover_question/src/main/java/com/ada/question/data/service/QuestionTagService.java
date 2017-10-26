package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionTag;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionTagService {

	QuestionTag findById(Long id);

	QuestionTag save(QuestionTag bean);

	QuestionTag update(QuestionTag bean);

	QuestionTag deleteById(Long id);
	
	QuestionTag[] deleteByIds(Long[] ids);
	
	Page<QuestionTag> page(Pageable pageable);
	
	Page<QuestionTag> page(Pageable pageable, Object search);


	List<QuestionTag> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}