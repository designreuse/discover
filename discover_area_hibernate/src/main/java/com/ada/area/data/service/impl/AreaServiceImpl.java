package com.ada.area.data.service.impl;

import com.ada.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.area.data.dao.AreaDao;
import com.ada.area.data.entity.Area;
import com.ada.area.data.service.AreaService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年08月04日10:01:33.
*/
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	private AreaDao dao;


	@Override
	@Transactional(readOnly = true)
	public Area findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Area> findByTops(Integer pid) {
		LinkedList<Area> result = new LinkedList<Area>();
		Area catalog = dao.findById(pid);
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
	public Area save(Area bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Area update(Area bean) {
		Updater<Area> updater = new Updater<Area>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Area deleteById(Integer id) {
		Area bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Area[] deleteByIds(Integer[] ids) {
		Area[] beans = new Area[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	@Override
	public Area findByName(String name) {
		return dao.findByName(name);
	}


	@Autowired
	public void setDao(AreaDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Area> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Area> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Area> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}