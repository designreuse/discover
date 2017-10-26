package com.ada.user.data.service.impl;

import com.ada.data.core.Finder;
import com.ada.data.rest.domain.AbstractVo;
import com.ada.discover.rest.base.ResponseObject;
import com.ada.user.data.dao.UserInfoDao;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.vo.UserAccountVo;
import com.ada.user.enums.AccountType;
import com.ada.user.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.user.data.dao.UserAccountDao;
import com.ada.user.data.entity.UserAccount;
import com.ada.user.data.service.UserAccountService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;

import com.ada.data.utils.FilterUtils;


/**
 * Created by imake on 2017年07月20日16:24:20.
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountDao dao;

    @Autowired
    private UserInfoDao infoDao;

    public UserAccountVo reg(UserAccount bean) {
        return dao.reg(bean);
    }

    @Override
    public AbstractVo updatePassword(Long user, AccountType accountType, String oldpassword, String password) {
        AbstractVo result = new AbstractVo();
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.accountType=:accountType");
        finder.setParam("accountType", accountType);
        finder.append(" and u.user.id=:user");
        finder.setParam("user", user);
        UserAccount account = dao.findOne(finder);
        if (account == null) {
            result.setCode(-1);
            result.setMsg("该账号不存在");
            return result;
        }

        SecurityUtil securityUtil = new SecurityUtil(account.getSalt());
        if (!securityUtil.checkPassword(account.getPassword(), oldpassword)) {
            result.setCode(-2);
            result.setMsg("老密码不正确");
            return result;
        }
        account.setPassword(securityUtil.entryptPassword(password));
        result.setMsg("修改密码成功");
        return result;
    }


    @Override
    @Transactional(readOnly = true)
    public UserAccount findById(Long id) {
        return dao.findById(id);
    }


    @Override
    @Transactional
    public UserAccount save(UserAccount bean) {
        dao.save(bean);
        return bean;
    }

    @Override
    @Transactional
    public UserAccount update(UserAccount bean) {
        Updater<UserAccount> updater = new Updater<UserAccount>(bean);
        return dao.updateByUpdater(updater);
    }

    @Override
    @Transactional
    public UserAccount deleteById(Long id) {
        UserAccount bean = dao.findById(id);
        dao.deleteById(id);
        return bean;
    }

    @Override
    @Transactional
    public UserAccount[] deleteByIds(Long[] ids) {
        UserAccount[] beans = new UserAccount[ids.length];
        for (int i = 0, len = ids.length; i < len; i++) {
            beans[i] = deleteById(ids[i]);
        }
        return beans;
    }


    @Autowired
    public void setDao(UserAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public Page<UserAccount> page(Pageable pageable) {
        return dao.page(pageable);
    }


    @Override
    public Page<UserAccount> page(Pageable pageable, Object search) {
        List<Filter> filters = FilterUtils.getFilters(search);
        if (filters != null) {
            pageable.getFilters().addAll(filters);
        }
        return dao.page(pageable);
    }

    @Override
    public List<UserAccount> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first, size, filters, orders);
    }

    @Override
    public UserAccount findByUserName(String username, AccountType accountType) {
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.username=:username and u.accountType=:accountType");
        finder.setParam("username", username);
        finder.setParam("accountType", accountType);
        return dao.findOne(finder);
    }

    @Override
    public UserAccount updateUserLogin(UserAccount userAccount) {
        UserAccount account = null;
        if (userAccount.getId() == null) {
            return null;
        }
        account = dao.findById(userAccount.getId());
        if (account == null) {
            return null;
        }
        Integer size = account.getLoginSize();
        if (size == null) {
            size = 1;
        }
        size++;
        account.setLoginSize(size);
        account.setLastDate(new Date());
        return account;
    }

    @Override
    public ResponseObject restPassword(UserAccount userAccount) {
        ResponseObject result=new ResponseObject();
        if (userAccount.getId() == null) {
            result.setMsg("账号不存在");
            result.setCode(-1);
            return result;
        }
        if (userAccount.getPassword()==null||userAccount.getPassword().length()<3){
            result.setMsg("密码过短，长度必须大于3位！");
            result.setCode(-3);
            return result;
        }
        UserAccount  account = dao.findById(userAccount.getId());
        if (account == null) {
            result.setMsg("账号不存在");
            result.setCode(-2);
            return result;
        }
        SecurityUtil securityUtil = new SecurityUtil();
        account.setSalt(securityUtil.getSalt());
        account.setPassword(securityUtil.entryptPassword(userAccount.getPassword()));
        result.setMsg("重置密码成功");
        return result;
    }
}