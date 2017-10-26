package com.ada.bbs.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.bbs.data.dao.ForumPostDao;
import com.ada.bbs.data.entity.ForumPost;
import com.ada.bbs.data.service.ForumPostService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年06月22日21:16:38.
*/
@Service
@Transactional
public class ForumPostServiceImpl implements ForumPostService {

	private ForumPostDao dao;


	@Override
	@Transactional(readOnly = true)
	public ForumPost findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ForumPost save(ForumPost bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ForumPost update(ForumPost bean) {
		Updater<ForumPost> updater = new Updater<ForumPost>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ForumPost deleteById(Long id) {
		ForumPost bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ForumPost[] deleteByIds(Long[] ids) {
		ForumPost[] beans = new ForumPost[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ForumPostDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ForumPost> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<ForumPost> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForumPost> list(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.list(first,count,filters,orders);
	}

    @Override
	public Page<ForumPost> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
}