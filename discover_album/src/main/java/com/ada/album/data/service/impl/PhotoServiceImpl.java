package com.ada.album.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.album.data.dao.PhotoDao;
import com.ada.album.data.entity.Photo;
import com.ada.album.data.service.PhotoService;

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
public class PhotoServiceImpl implements PhotoService {

	private PhotoDao dao;


	@Override
	@Transactional(readOnly = true)
	public Photo findById(String id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Photo save(Photo bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Photo update(Photo bean) {
		Updater<Photo> updater = new Updater<Photo>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Photo deleteById(String id) {
		Photo bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Photo[] deleteByIds(String[] ids) {
		Photo[] beans = new Photo[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(PhotoDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Photo> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Photo> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Photo> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}