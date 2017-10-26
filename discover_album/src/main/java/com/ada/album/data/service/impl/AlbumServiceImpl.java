package com.ada.album.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.album.data.dao.AlbumDao;
import com.ada.album.data.entity.Album;
import com.ada.album.data.service.AlbumService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日10:04:54.
*/


@Scope("prototype")
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

	private AlbumDao dao;


	@Override
	@Transactional(readOnly = true)
	public Album findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Album save(Album bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Album update(Album bean) {
		Updater<Album> updater = new Updater<Album>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Album deleteById(Long id) {
		Album bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Album[] deleteByIds(Long[] ids) {
		Album[] beans = new Album[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AlbumDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Album> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Album> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Album> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}