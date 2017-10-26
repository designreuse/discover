package com.ada.site.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import  com.ada.site.data.entity.App;

/**
* Created by imake on 2017年07月25日11:33:24.
*/
public interface AppDao extends BaseDao<App,Long>{

	public App findById(Long id);

	public App save(App bean);

	public App updateByUpdater(Updater<App> updater);

	public App deleteById(Long id);


	Long count(Filter... filters);


}