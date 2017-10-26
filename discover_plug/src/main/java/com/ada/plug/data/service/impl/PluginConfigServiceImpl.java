package com.ada.plug.data.service.impl;

import com.ada.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.plug.data.dao.PluginConfigDao;
import com.ada.plug.data.entity.PluginConfig;
import com.ada.plug.data.service.PluginConfigService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年08月15日11:13:49.
*/


@Scope("prototype")
@Service
@Transactional
public class PluginConfigServiceImpl implements PluginConfigService {

	private PluginConfigDao dao;


	@Override
	@Transactional(readOnly = true)
	public PluginConfig findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public PluginConfig save(PluginConfig bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public PluginConfig update(PluginConfig bean) {
		Updater<PluginConfig> updater = new Updater<PluginConfig>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public PluginConfig deleteById(Long id) {
		PluginConfig bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public PluginConfig[] deleteByIds(Long[] ids) {
		PluginConfig[] beans = new PluginConfig[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(PluginConfigDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<PluginConfig> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<PluginConfig> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<PluginConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}

	@Override
	public boolean pluginIdExists(String id) {
		Finder finder=Finder.create();
		finder.append(" from PluginConfig p where p.pluginId =:pluginId ");
		finder.setParam("pluginId",id);
		Long count = dao.countQuery(finder);
		return count > 0;
	}

	@Override
	public PluginConfig findByPluginId(String id) {
		List<PluginConfig> plugs = dao.findByProperty("pluginId", id);
		if (plugs != null && plugs.size() > 0) {
			return plugs.get(0);

		} else {
			return null;
		}
	}
}