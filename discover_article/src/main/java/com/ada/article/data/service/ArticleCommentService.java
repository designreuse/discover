package com.ada.article.data.service;

import com.ada.article.data.entity.ArticleComment;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface ArticleCommentService {

	ArticleComment findById(Long id);

	ArticleComment save(ArticleComment bean);

	ArticleComment update(ArticleComment bean);

	ArticleComment deleteById(Long id);
	
	ArticleComment[] deleteByIds(Long[] ids);
	
	Page<ArticleComment> page(Pageable pageable);
	
	Page<ArticleComment> page(Pageable pageable, Object search);


	List<ArticleComment> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}