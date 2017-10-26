package com.ada.plug.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.plug.data.entity.SystemPayment;

/**
* Created by imake on 2017年08月15日11:13:49.
*/
public interface SystemPaymentDao extends BaseDao<SystemPayment,Long>{

	 SystemPayment findById(Long id);

	 SystemPayment save(SystemPayment bean);

	 SystemPayment updateByUpdater(Updater<SystemPayment> updater);

	 SystemPayment deleteById(Long id);
}