package com.ada.album.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.album.data.dao.CategoryDao;
import com.ada.album.data.entity.Category;
import com.ada.album.data.service.CategoryService;

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
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao dao;


	@Override
	@Transactional(readOnly = true)
	public Category findById(String id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Category save(Category bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Category update(Category bean) {
		Updater<Category> updater = new Updater<Category>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Category deleteById(String id) {
		Category bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Category[] deleteByIds(String[] ids) {
		Category[] beans = new Category[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(CategoryDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Category> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Category> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Category> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}