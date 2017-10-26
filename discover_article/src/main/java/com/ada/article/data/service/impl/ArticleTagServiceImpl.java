package com.ada.article.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.article.data.dao.ArticleTagDao;
import com.ada.article.data.entity.ArticleTag;
import com.ada.article.data.service.ArticleTagService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日09:52:13.
*/


@Scope("prototype")
@Service
@Transactional
public class ArticleTagServiceImpl implements ArticleTagService {

	private ArticleTagDao dao;


	@Override
	@Transactional(readOnly = true)
	public ArticleTag findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public ArticleTag save(ArticleTag bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public ArticleTag update(ArticleTag bean) {
		Updater<ArticleTag> updater = new Updater<ArticleTag>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public ArticleTag deleteById(Long id) {
		ArticleTag bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public ArticleTag[] deleteByIds(Long[] ids) {
		ArticleTag[] beans = new ArticleTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ArticleTagDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<ArticleTag> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<ArticleTag> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<ArticleTag> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}