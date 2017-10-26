package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionCatalogService {

	QuestionCatalog findById(Integer id);

	QuestionCatalog save(QuestionCatalog bean);

	QuestionCatalog update(QuestionCatalog bean);

	QuestionCatalog deleteById(Integer id);
	
	QuestionCatalog[] deleteByIds(Integer[] ids);
	
	Page<QuestionCatalog> page(Pageable pageable);
	
	Page<QuestionCatalog> page(Pageable pageable, Object search);

	List<QuestionCatalog> findByTops(Integer pid);

	List<QuestionCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}