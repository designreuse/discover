package com.ada.article.data.service;

import com.ada.article.data.entity.SensitiveCategory;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface SensitiveCategoryService {

	SensitiveCategory findById(Integer id);

	SensitiveCategory save(SensitiveCategory bean);

	SensitiveCategory update(SensitiveCategory bean);

	SensitiveCategory deleteById(Integer id);
	
	SensitiveCategory[] deleteByIds(Integer[] ids);
	
	Page<SensitiveCategory> page(Pageable pageable);
	
	Page<SensitiveCategory> page(Pageable pageable, Object search);

	List<SensitiveCategory> findByTops(Integer pid);

	List<SensitiveCategory> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}