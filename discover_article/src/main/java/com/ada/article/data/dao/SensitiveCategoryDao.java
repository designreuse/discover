package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.SensitiveCategory;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface SensitiveCategoryDao extends BaseDao<SensitiveCategory,Integer>{

	 SensitiveCategory findById(Integer id);

	 SensitiveCategory save(SensitiveCategory bean);

	 SensitiveCategory updateByUpdater(Updater<SensitiveCategory> updater);

	 SensitiveCategory deleteById(Integer id);
}