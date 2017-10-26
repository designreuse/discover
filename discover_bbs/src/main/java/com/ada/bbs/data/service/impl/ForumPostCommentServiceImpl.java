package com.ada.bbs.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.bbs.data.dao.ForumPostCommentDao;
import com.ada.bbs.data.entity.ForumPostComment;
import com.ada.bbs.data.service.ForumPostCommentService;

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
public class ForumPostCommentServiceImpl implements ForumPostCommentService {

	private ForumPostCommentDao dao;


	@Override
	@Transactional(readOnly = true)
	public ForumPostComment findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ForumPostComment save(ForumPostComment bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ForumPostComment update(ForumPostComment bean) {
		Updater<ForumPostComment> updater = new Updater<ForumPostComment>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ForumPostComment deleteById(Long id) {
		ForumPostComment bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ForumPostComment[] deleteByIds(Long[] ids) {
		ForumPostComment[] beans = new ForumPostComment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ForumPostCommentDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ForumPostComment> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<ForumPostComment> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForumPostComment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<ForumPostComment> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
}