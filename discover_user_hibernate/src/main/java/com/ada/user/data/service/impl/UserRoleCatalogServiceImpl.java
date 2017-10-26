package com.ada.user.data.service.impl;

import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.data.utils.FilterUtils;
import com.ada.user.data.dao.UserRoleCatalogDao;
import com.ada.user.data.entity.UserRoleCatalog;
import com.ada.user.data.service.UserRoleCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;


/**
* Created by imake on 2017年08月09日13:36:13.
*/


@Scope("prototype")
@Service
@Transactional
public class UserRoleCatalogServiceImpl implements UserRoleCatalogService {

	private UserRoleCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public UserRoleCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<UserRoleCatalog> findByTops(Integer pid) {
		LinkedList<UserRoleCatalog> result = new LinkedList<UserRoleCatalog>();
		UserRoleCatalog catalog = dao.findById(pid);
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
	public UserRoleCatalog save(UserRoleCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public UserRoleCatalog update(UserRoleCatalog bean) {
		Updater<UserRoleCatalog> updater = new Updater<UserRoleCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public UserRoleCatalog deleteById(Integer id) {
		UserRoleCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public UserRoleCatalog[] deleteByIds(Integer[] ids) {
		UserRoleCatalog[] beans = new UserRoleCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(UserRoleCatalogDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<UserRoleCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<UserRoleCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<UserRoleCatalog> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}