package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/6/29.
 */
public class UserLoginCodeRequest extends RequestTokenObject {

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

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
