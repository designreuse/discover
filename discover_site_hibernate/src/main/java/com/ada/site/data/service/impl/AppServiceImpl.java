package com.ada.site.data.service.impl;

import com.ada.data.core.Finder;
import com.ada.user.word.AdaptiveRandomWordFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.data.dao.AppDao;
import com.ada.site.data.entity.App;
import com.ada.site.data.service.AppService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年07月25日11:33:24.
*/
@Service
@Transactional
public class AppServiceImpl implements AppService {

	private AppDao dao;


	@Override
	@Transactional(readOnly = true)
	public App findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public App findByKey(String key) {
		Finder finder=Finder.create();
		finder.append("from App a where a.appKey=:appKey");
		finder.setParam("appKey",key);
		return dao.findOne(finder);
	}


	@Override
    @Transactional
	public App save(App bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public App update(App bean) {
		Updater<App> updater = new Updater<App>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public App deleteById(Long id) {
		App bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public App[] deleteByIds(Long[] ids) {
		App[] beans = new App[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(AppDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<App> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<App> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<App> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public App visit(Long id) {
		App entity = dao.findById(id);
		if (entity != null) {
			Long counts = entity.getCounts();
			if (counts == null) {
				counts = 0l;
			}
			counts++;
			entity.setCounts(counts);
		}
		return entity;
	}

	@Override
	public String key() {
		String result = "";
		AdaptiveRandomWordFactory f = new AdaptiveRandomWordFactory();
		f.setMinLength(8);
		f.setMaxLength(12);
		f.setCharacters("1234567890abcdefhjkmnpwx");
		result = f.getNextWord();
		while (dao.count(Filter.eq("appKey", result)) > 0) {
			result = f.getNextWord();
		}
		return result;
	}

	@Override
	public String secret() {
		AdaptiveRandomWordFactory f = new AdaptiveRandomWordFactory();
		f.setMinLength(16);
		f.setMaxLength(32);
		f.setCharacters("1234567890abcdefhjkmnpwx");
		return f.getNextWord();
	}
}