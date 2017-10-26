package com.ada.quartz.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.quartz.data.entity.CronTaskRecord;

/**
* Created by imake on 2017年08月24日14:40:18.
*/
public interface CronTaskRecordDao extends BaseDao<CronTaskRecord,Long>{

	 CronTaskRecord findById(Long id);

	 CronTaskRecord save(CronTaskRecord bean);

	 CronTaskRecord updateByUpdater(Updater<CronTaskRecord> updater);

	 CronTaskRecord deleteById(Long id);
}