package com.ada.question.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.question.data.dao.QuestionVoteDao;
import com.ada.question.data.entity.QuestionVote;
import com.ada.question.data.service.QuestionVoteService;

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
public class QuestionVoteServiceImpl implements QuestionVoteService {

	private QuestionVoteDao dao;


	@Override
	@Transactional(readOnly = true)
	public QuestionVote findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public QuestionVote save(QuestionVote bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public QuestionVote update(QuestionVote bean) {
		Updater<QuestionVote> updater = new Updater<QuestionVote>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public QuestionVote deleteById(Long id) {
		QuestionVote bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public QuestionVote[] deleteByIds(Long[] ids) {
		QuestionVote[] beans = new QuestionVote[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(QuestionVoteDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<QuestionVote> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<QuestionVote> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<QuestionVote> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}