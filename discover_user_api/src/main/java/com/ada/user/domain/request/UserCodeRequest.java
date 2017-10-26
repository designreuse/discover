package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/6/29.
 */
public class UserCodeRequest  extends RequestTokenObject {

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 验证码类型 register,login
     */
    private String catalog;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
