package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/6/29.
 */
public class UserRegisterCodeRequest extends RequestTokenObject {

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     *密码
     */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
