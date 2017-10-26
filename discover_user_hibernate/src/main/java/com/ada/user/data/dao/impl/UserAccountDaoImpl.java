package com.ada.user.data.dao.impl;

import com.ada.data.core.Finder;
import com.ada.user.data.dao.UserInfoDao;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.vo.UserAccountVo;
import com.ada.user.enums.AccountType;
import com.ada.user.utils.SecurityUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.user.data.dao.UserAccountDao;
import com.ada.user.data.entity.UserAccount;

import java.util.List;

/**
 * Created by imake on 2017年07月20日16:24:20.
 */
@Repository

public class UserAccountDaoImpl extends CriteriaDaoImpl<UserAccount, Long> implements UserAccountDao {

    @Autowired
    UserInfoDao infoDao;

    @Override
    public UserAccount findById(Long id) {
        if (id == null) {
            return null;
        }
        return get(id);
    }

    @Override
    public UserAccount save(UserAccount bean) {

        getSession().save(bean);


        return bean;
    }

    @Override
    public UserAccount deleteById(Long id) {
        UserAccount entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    public UserAccountVo reg(UserAccount bean) {
        UserAccountVo result = new UserAccountVo();
        if (bean == null) {
            result.setCode(-1);
            result.setMsg("数据无效");
            return result;
        }
        if (bean.getUsername() == null || bean.getUsername().length() < 2) {
            result.setCode(-2);
            result.setMsg("用户名长度过短");
            return result;
        }
        if (bean.getPassword() == null || bean.getPassword().length() < 2) {
            result.setCode(-3);
            result.setMsg("密码过短");
            return result;
        }
        if (bean.getAccountType() == null) {
            bean.setAccountType(AccountType.Account);
        }

        Long size = checkUserName(bean.getUsername(), bean.getAccountType());
        if (size > 0) {
            result.setCode(-4);
            result.setMsg("该账号已经注册");
            return result;
        } else {
            UserInfo user = new UserInfo();
            user.setName(bean.getUsername());
            infoDao.save(user);
            bean.setUser(user);
            SecurityUtil securityUtil = new SecurityUtil();
            String oldpassword = securityUtil.entryptPassword(bean.getPassword());
            bean.setPassword(oldpassword);
            bean.setSalt(securityUtil.getSalt());
            save(bean);
            result.setId(bean.getId());
            result.setUser(user.getId());
        }
        return result;
    }

    @Override
    public UserAccountVo binding(String phone, Long user, AccountType type, String password) {
        UserAccountVo result = new UserAccountVo();
        Long size = checkUserName(phone, type);
        if (size > 0) {
            result.setCode(-1);
            result.setMsg("该账号已被使用");
            return result;
        }
        UserInfo info = infoDao.findById(user);
        if (info == null) {
            result.setCode(-2);
            result.setMsg("用户信息不存在");
            return result;
        }
        info.setPhone(phone);
        UserAccount bean = new UserAccount();
        bean.setAccountType(type);
        bean.setUsername(phone);
        bean.setLoginSize(0);
        if (password != null) {
            SecurityUtil securityUtil = new SecurityUtil();
            String oldpassword = securityUtil.entryptPassword(password);
            bean.setPassword(oldpassword);
            bean.setSalt(securityUtil.getSalt());
        }
        bean.setUser(info);
        save(bean);

        return result;
    }

    @Override
    public Long checkUserName(String phone, AccountType type) {
        Finder finder = Finder.create();
        finder.append("from UserAccount u where u.username ='" + phone + "'");
        finder.append(" and u.accountType=:accountType");
        finder.setParam("accountType", type);
        return countQuery(finder);
    }

    @Override
    protected Class<UserAccount> getEntityClass() {
        return UserAccount.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}