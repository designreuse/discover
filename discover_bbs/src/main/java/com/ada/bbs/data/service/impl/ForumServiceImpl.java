package com.ada.bbs.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.bbs.data.dao.ForumDao;
import com.ada.bbs.data.entity.Forum;
import com.ada.bbs.data.service.ForumService;

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
public class ForumServiceImpl implements ForumService {

	private ForumDao dao;


	@Override
	@Transactional(readOnly = true)
	public Forum findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Forum> findByTops(Integer pid) {
		LinkedList<Forum> result = new LinkedList<Forum>();
		Forum catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}

	@Override
    @Transactional
	public Forum save(Forum bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Forum update(Forum bean) {
		Updater<Forum> updater = new Updater<Forum>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Forum deleteById(Integer id) {
		Forum bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Forum[] deleteByIds(Integer[] ids) {
		Forum[] beans = new Forum[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ForumDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Forum> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Forum> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Forum> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}