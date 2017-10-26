package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.ForumPostComment;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月22日21:16:38.
*/
public interface ForumPostCommentService {

	public ForumPostComment findById(Long id);

	public ForumPostComment save(ForumPostComment bean);

	public ForumPostComment update(ForumPostComment bean);

	public ForumPostComment deleteById(Long id);
	
	public ForumPostComment[] deleteByIds(Long[] ids);
	
	public Page<ForumPostComment> findPage(Pageable pageable);
	
	public Page<ForumPostComment> page(Pageable pageable);
	
	public Page<ForumPostComment> page(Pageable pageable, Object search);

	public long count(Filter... filters);


	public List<ForumPostComment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}