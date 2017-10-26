package com.ada.question.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.question.data.dao.QuestionAnswerDao;
import com.ada.question.data.entity.QuestionAnswer;
import com.ada.question.data.service.QuestionAnswerService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日11:06:23.
*/


@Scope("prototype")
@Service
@Transactional
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	private QuestionAnswerDao dao;


	@Override
	@Transactional(readOnly = true)
	public QuestionAnswer findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public QuestionAnswer save(QuestionAnswer bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public QuestionAnswer update(QuestionAnswer bean) {
		Updater<QuestionAnswer> updater = new Updater<QuestionAnswer>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public QuestionAnswer deleteById(Long id) {
		QuestionAnswer bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public QuestionAnswer[] deleteByIds(Long[] ids) {
		QuestionAnswer[] beans = new QuestionAnswer[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(QuestionAnswerDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<QuestionAnswer> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<QuestionAnswer> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<QuestionAnswer> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}