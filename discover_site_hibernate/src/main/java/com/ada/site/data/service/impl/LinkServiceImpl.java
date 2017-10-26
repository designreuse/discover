package com.ada.site.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.data.dao.LinkDao;
import com.ada.site.data.entity.Link;
import com.ada.site.data.service.LinkService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月25日11:33:25.
*/
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

	private LinkDao dao;


	@Override
	@Transactional(readOnly = true)
	public Link findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Link save(Link bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Link update(Link bean) {
		Updater<Link> updater = new Updater<Link>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Link deleteById(Long id) {
		Link bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Link[] deleteByIds(Long[] ids) {
		Link[] beans = new Link[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(LinkDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Link> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Link> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Link> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}