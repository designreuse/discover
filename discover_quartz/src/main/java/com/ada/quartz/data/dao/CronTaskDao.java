package com.ada.quartz.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.quartz.data.entity.CronTask;

/**
* Created by imake on 2017年08月24日14:31:26.
*/
public interface CronTaskDao extends BaseDao<CronTask,Long>{

	 CronTask findById(Long id);

	 CronTask save(CronTask bean);

	 CronTask updateByUpdater(Updater<CronTask> updater);

	 CronTask deleteById(Long id);
}