package com.ada.bbs.data.service;

import com.ada.bbs.data.entity.Forum;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年06月27日22:43:54.
*/
public interface ForumService {

	public Forum findById(Integer id);

	public Forum save(Forum bean);

	public Forum update(Forum bean);

	public Forum deleteById(Integer id);
	
	public Forum[] deleteByIds(Integer[] ids);
	

	public Page<Forum> page(Pageable pageable);
	
	public Page<Forum> page(Pageable pageable, Object search);


	public	List<Forum> findByTops(Integer pid);
	public  List<Forum> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}