package com.ada.article.data.service;

import com.ada.article.data.entity.ArticleTag;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface ArticleTagService {

	ArticleTag findById(Long id);

	ArticleTag save(ArticleTag bean);

	ArticleTag update(ArticleTag bean);

	ArticleTag deleteById(Long id);
	
	ArticleTag[] deleteByIds(Long[] ids);
	
	Page<ArticleTag> page(Pageable pageable);
	
	Page<ArticleTag> page(Pageable pageable, Object search);


	List<ArticleTag> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}