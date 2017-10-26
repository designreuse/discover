package com.ada.web.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.web.data.entity.WebTheme;

/**
* Created by imake on 2017年08月30日10:16:29.
*/
public interface WebThemeDao extends BaseDao<WebTheme,String>{

	 WebTheme findById(String id);

	 WebTheme save(WebTheme bean);

	 WebTheme updateByUpdater(Updater<WebTheme> updater);

	 WebTheme deleteById(String id);
}