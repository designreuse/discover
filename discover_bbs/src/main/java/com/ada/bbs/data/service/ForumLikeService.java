package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.ForumLike;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
public interface ForumLikeService {

	public ForumLike findById(Long id);

	public ForumLike save(ForumLike bean);

	public ForumLike update(ForumLike bean);

	public ForumLike deleteById(Long id);
	
	public ForumLike[] deleteByIds(Long[] ids);
	

	public Page<ForumLike> page(Pageable pageable);
	
	public Page<ForumLike> page(Pageable pageable, Object search);


	public  List<ForumLike> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}