package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.ForumPostText;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostTextService {

	public ForumPostText findById(Long id);

	public ForumPostText save(ForumPostText bean);

	public ForumPostText update(ForumPostText bean);

	public ForumPostText deleteById(Long id);
	
	public ForumPostText[] deleteByIds(Long[] ids);
	
	public Page<ForumPostText> findPage(Pageable pageable);
	
	public Page<ForumPostText> page(Pageable pageable);
	
	public Page<ForumPostText> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<ForumPostText> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}