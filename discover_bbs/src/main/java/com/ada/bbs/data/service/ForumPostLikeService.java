package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.ForumPostLike;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostLikeService {

	public ForumPostLike findById(Long id);

	public ForumPostLike save(ForumPostLike bean);

	public ForumPostLike update(ForumPostLike bean);

	public ForumPostLike deleteById(Long id);
	
	public ForumPostLike[] deleteByIds(Long[] ids);
	
	public Page<ForumPostLike> findPage(Pageable pageable);
	
	public Page<ForumPostLike> page(Pageable pageable);
	
	public Page<ForumPostLike> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<ForumPostLike> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}