package com.ada.user.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Updater;
import com.ada.user.data.entity.UserAccount;
import com.ada.user.data.vo.UserAccountVo;
import com.ada.user.enums.AccountType;

/**
 * Created by imake on 2017年07月20日16:24:20.
 */
public interface UserAccountDao extends BaseDao<UserAccount, Long> {

    UserAccount findById(Long id);

    UserAccount save(UserAccount bean);

    UserAccount updateByUpdater(Updater<UserAccount> updater);

    UserAccount deleteById(Long id);

    UserAccountVo reg(UserAccount bean);


    UserAccountVo binding(String phone, Long  user, AccountType type, String password);

    Long checkUserName(String phone, AccountType type);
}