package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/7/4.
 */
public class UserResetPasswordRequestion  extends RequestTokenObject {

    /**
     *
     */
    private String phone;

    private String code;

    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
