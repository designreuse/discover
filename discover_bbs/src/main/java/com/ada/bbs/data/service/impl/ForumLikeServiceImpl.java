package com.ada.bbs.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.bbs.data.dao.ForumLikeDao;
import com.ada.bbs.data.entity.ForumLike;
import com.ada.bbs.data.service.ForumLikeService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年06月27日22:43:54.
*/
@Service
@Transactional
public class ForumLikeServiceImpl implements ForumLikeService {

	private ForumLikeDao dao;


	@Override
	@Transactional(readOnly = true)
	public ForumLike findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ForumLike save(ForumLike bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ForumLike update(ForumLike bean) {
		Updater<ForumLike> updater = new Updater<ForumLike>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ForumLike deleteById(Long id) {
		ForumLike bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ForumLike[] deleteByIds(Long[] ids) {
		ForumLike[] beans = new ForumLike[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ForumLikeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ForumLike> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ForumLike> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ForumLike> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}