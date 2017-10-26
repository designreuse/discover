package com.ada.question.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.question.data.dao.QuestionPointsDao;
import com.ada.question.data.entity.QuestionPoints;
import com.ada.question.data.service.QuestionPointsService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日11:06:24.
*/


@Scope("prototype")
@Service
@Transactional
public class QuestionPointsServiceImpl implements QuestionPointsService {

	private QuestionPointsDao dao;


	@Override
	@Transactional(readOnly = true)
	public QuestionPoints findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public QuestionPoints save(QuestionPoints bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public QuestionPoints update(QuestionPoints bean) {
		Updater<QuestionPoints> updater = new Updater<QuestionPoints>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public QuestionPoints deleteById(Long id) {
		QuestionPoints bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public QuestionPoints[] deleteByIds(Long[] ids) {
		QuestionPoints[] beans = new QuestionPoints[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(QuestionPointsDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<QuestionPoints> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<QuestionPoints> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<QuestionPoints> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}