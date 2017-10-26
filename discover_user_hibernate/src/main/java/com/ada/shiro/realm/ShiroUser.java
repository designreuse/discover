package com.ada.shiro.realm;

import java.io.Serializable;

/**
 * Created by ada on 2017/6/26.
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public Long id;
    public String loginName;
    public String name;

    public ShiroUser(Long id, String loginName, String name) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
       ShiroUser other = (ShiroUser) obj;
        if (loginName == null) {
            if (other.loginName != null) {
                return false;
            }
        } else if (!loginName.equals(other.loginName)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * 重载hashCode,只计算loginName;
     */
    @Override
    public int hashCode() {
        if (loginName != null) {
            return loginName.hashCode();
        } else {
            return 0;
        }
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginName;
    }
}
