package com.ada.plug.data.service;

import com.ada.plug.data.entity.PluginConfig;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
public interface PluginConfigService {

	PluginConfig findById(Long id);

	PluginConfig save(PluginConfig bean);

	PluginConfig update(PluginConfig bean);

	PluginConfig deleteById(Long id);
	
	PluginConfig[] deleteByIds(Long[] ids);
	
	Page<PluginConfig> page(Pageable pageable);
	
	Page<PluginConfig> page(Pageable pageable, Object search);


	List<PluginConfig> list(int first, Integer size, List<Filter> filters, List<Order> orders);

    boolean pluginIdExists(String id);

	PluginConfig findByPluginId(String id);
}