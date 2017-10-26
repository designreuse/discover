package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionPoints;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionPointsService {

	QuestionPoints findById(Long id);

	QuestionPoints save(QuestionPoints bean);

	QuestionPoints update(QuestionPoints bean);

	QuestionPoints deleteById(Long id);
	
	QuestionPoints[] deleteByIds(Long[] ids);
	
	Page<QuestionPoints> page(Pageable pageable);
	
	Page<QuestionPoints> page(Pageable pageable, Object search);


	List<QuestionPoints> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}