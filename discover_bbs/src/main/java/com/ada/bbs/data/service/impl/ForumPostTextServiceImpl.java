package com.ada.bbs.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.bbs.data.dao.ForumPostTextDao;
import com.ada.bbs.data.entity.ForumPostText;
import com.ada.bbs.data.service.ForumPostTextService;

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
public class ForumPostTextServiceImpl implements ForumPostTextService {

	private ForumPostTextDao dao;


	@Override
	@Transactional(readOnly = true)
	public ForumPostText findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ForumPostText save(ForumPostText bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ForumPostText update(ForumPostText bean) {
		Updater<ForumPostText> updater = new Updater<ForumPostText>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ForumPostText deleteById(Long id) {
		ForumPostText bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ForumPostText[] deleteByIds(Long[] ids) {
		ForumPostText[] beans = new ForumPostText[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ForumPostTextDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ForumPostText> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<ForumPostText> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForumPostText> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<ForumPostText> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
}