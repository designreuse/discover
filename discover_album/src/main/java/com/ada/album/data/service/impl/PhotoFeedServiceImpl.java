package com.ada.album.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.album.data.dao.PhotoFeedDao;
import com.ada.album.data.entity.PhotoFeed;
import com.ada.album.data.service.PhotoFeedService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日10:04:55.
*/


@Scope("prototype")
@Service
@Transactional
public class PhotoFeedServiceImpl implements PhotoFeedService {

	private PhotoFeedDao dao;


	@Override
	@Transactional(readOnly = true)
	public PhotoFeed findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public PhotoFeed save(PhotoFeed bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public PhotoFeed update(PhotoFeed bean) {
		Updater<PhotoFeed> updater = new Updater<PhotoFeed>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public PhotoFeed deleteById(Long id) {
		PhotoFeed bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public PhotoFeed[] deleteByIds(Long[] ids) {
		PhotoFeed[] beans = new PhotoFeed[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(PhotoFeedDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<PhotoFeed> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<PhotoFeed> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<PhotoFeed> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}