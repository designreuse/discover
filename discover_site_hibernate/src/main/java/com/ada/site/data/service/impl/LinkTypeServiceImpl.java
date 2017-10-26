package com.ada.site.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.data.dao.LinkTypeDao;
import com.ada.site.data.entity.LinkType;
import com.ada.site.data.service.LinkTypeService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月28日16:29:13.
*/


@Scope("prototype")
@Service
@Transactional
public class LinkTypeServiceImpl implements LinkTypeService {

	private LinkTypeDao dao;


	@Override
	@Transactional(readOnly = true)
	public LinkType findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<LinkType> findByTops(Integer pid) {
		LinkedList<LinkType> result = new LinkedList<LinkType>();
		LinkType catalog = dao.findById(pid);
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
	public LinkType save(LinkType bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public LinkType update(LinkType bean) {
		Updater<LinkType> updater = new Updater<LinkType>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public LinkType deleteById(Integer id) {
		LinkType bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public LinkType[] deleteByIds(Integer[] ids) {
		LinkType[] beans = new LinkType[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(LinkTypeDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<LinkType> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<LinkType> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<LinkType> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}