package com.ada.article.data.service;

import com.ada.article.data.entity.SensitiveWord;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface SensitiveWordService {

	SensitiveWord findById(Long id);

	SensitiveWord save(SensitiveWord bean);

	SensitiveWord update(SensitiveWord bean);

	SensitiveWord deleteById(Long id);
	
	SensitiveWord[] deleteByIds(Long[] ids);
	
	Page<SensitiveWord> page(Pageable pageable);
	
	Page<SensitiveWord> page(Pageable pageable, Object search);


	List<SensitiveWord> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}