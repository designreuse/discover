package com.ada.ad.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.ad.data.entity.AdPosition;

/**
* Created by imake on 2017年10月10日13:39:55.
*/
public interface AdPositionDao extends BaseDao<AdPosition,Integer>{

	 AdPosition findById(Integer id);

	 AdPosition save(AdPosition bean);

	 AdPosition updateByUpdater(Updater<AdPosition> updater);

	 AdPosition deleteById(Integer id);
}