package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.ForumPost;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostService {

	public ForumPost findById(Long id);

	public ForumPost save(ForumPost bean);

	public ForumPost update(ForumPost bean);

	public ForumPost deleteById(Long id);
	
	public ForumPost[] deleteByIds(Long[] ids);
	
	public Page<ForumPost> findPage(Pageable pageable);
	
	public Page<ForumPost> page(Pageable pageable);
	
	public Page<ForumPost> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<ForumPost> list(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}