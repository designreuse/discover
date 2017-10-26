package com.ada.ad.data.service.impl;

import com.ada.ad.data.dao.AdPositionDao;
import com.ada.ad.data.entity.AdPosition;
import com.ada.ad.data.service.AdPositionService;
import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.data.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
* Created by imake on 2017年10月10日13:39:55.
*/


@Scope("prototype")
@Service
@Transactional
public class AdPositionServiceImpl implements AdPositionService {

	private AdPositionDao dao;


	@Override
	@Transactional(readOnly = true)
	public AdPosition findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<AdPosition> findByTops(Integer pid) {
		LinkedList<AdPosition> result = new LinkedList<AdPosition>();
		AdPosition catalog = dao.findById(pid);
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
    public List<AdPosition> child(Integer id,Integer max) {
        List<Order> orders=new ArrayList<Order>();
        orders.add(Order.asc("code"));
        List<Filter> list=new ArrayList<Filter>();
        list.add(Filter.eq("parent.id",id));
        return dao.list(0,max,list,orders);
	}

	@Override
    @Transactional
	public AdPosition save(AdPosition bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public AdPosition update(AdPosition bean) {
		Updater<AdPosition> updater = new Updater<AdPosition>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public AdPosition deleteById(Integer id) {
		AdPosition bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public AdPosition[] deleteByIds(Integer[] ids) {
		AdPosition[] beans = new AdPosition[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AdPositionDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<AdPosition> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<AdPosition> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<AdPosition> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}