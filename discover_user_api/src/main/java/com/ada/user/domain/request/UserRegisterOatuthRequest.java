package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * 用户通过第三方登陆对象
 * Created by ada on 2017/6/29.
 */
public class UserRegisterOatuthRequest extends RequestTokenObject {
    /**
     * 第三方登陆类型
     */
    String type;

    String accessToken;
    String openId;

    /**
     * 手机号码
     */
    String phone;


    /**
     * 手机验证码
     */
    String code;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
