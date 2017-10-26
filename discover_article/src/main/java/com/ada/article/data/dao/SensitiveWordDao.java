package com.ada.article.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.article.data.entity.SensitiveWord;

/**
* Created by imake on 2017年08月15日09:52:13.
*/
public interface SensitiveWordDao extends BaseDao<SensitiveWord,Long>{

	 SensitiveWord findById(Long id);

	 SensitiveWord save(SensitiveWord bean);

	 SensitiveWord updateByUpdater(Updater<SensitiveWord> updater);

	 SensitiveWord deleteById(Long id);
}