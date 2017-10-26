package com.ada.article.data.service;

import com.ada.article.data.entity.ArticleCatalog;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日09:52:12.
*/
public interface ArticleCatalogService {

	ArticleCatalog findById(Integer id);

	ArticleCatalog save(ArticleCatalog bean);

	ArticleCatalog update(ArticleCatalog bean);

	ArticleCatalog deleteById(Integer id);
	
	ArticleCatalog[] deleteByIds(Integer[] ids);
	
	Page<ArticleCatalog> page(Pageable pageable);
	
	Page<ArticleCatalog> page(Pageable pageable, Object search);

	List<ArticleCatalog> findByTops(Integer pid);

	List<ArticleCatalog> child(Integer pid);

	List<ArticleCatalog> childs(Integer pid);


	List<ArticleCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}