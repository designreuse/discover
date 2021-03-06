package com.ada.question.data.service;

import com.ada.question.data.entity.QuestionFavorite;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:06:24.
*/
public interface QuestionFavoriteService {

	QuestionFavorite findById(Long id);

	QuestionFavorite save(QuestionFavorite bean);

	QuestionFavorite update(QuestionFavorite bean);

	QuestionFavorite deleteById(Long id);
	
	QuestionFavorite[] deleteByIds(Long[] ids);
	
	Page<QuestionFavorite> page(Pageable pageable);
	
	Page<QuestionFavorite> page(Pageable pageable, Object search);


	List<QuestionFavorite> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}