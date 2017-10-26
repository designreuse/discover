package com.ada.ad.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.ad.data.entity.Ad;

/**
* Created by imake on 2017年10月10日12:04:43.
*/
public interface AdDao extends BaseDao<Ad,Long>{

	 Ad findById(Long id);

	 Ad save(Ad bean);

	 Ad updateByUpdater(Updater<Ad> updater);

	 Ad deleteById(Long id);
}