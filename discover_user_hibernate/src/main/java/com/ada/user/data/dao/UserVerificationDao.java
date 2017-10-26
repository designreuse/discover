package com.ada.user.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.ada.user.data.entity.UserVerification;

/**
* Created by imake on 2017年07月20日16:37:49.
*/
public interface UserVerificationDao extends BaseDao<UserVerification,Long>{

	public UserVerification findById(Long id);

	public UserVerification save(UserVerification bean);

	public UserVerification updateByUpdater(Updater<UserVerification> updater);

	public UserVerification deleteById(Long id);

    UserVerification findByName(String phone, Integer catalog);
}