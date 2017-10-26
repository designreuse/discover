package com.ada.article.data.service;

import com.ada.article.data.entity.Article;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
public interface ArticleService {

	Article findById(Long id);

	Article save(Article bean);

	Article update(Article bean);

	Article deleteById(Long id);
	
	Article[] deleteByIds(Long[] ids);
	
	Page<Article> page(Pageable pageable);
	
	Page<Article> page(Pageable pageable, Object search);


	List<Article> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}