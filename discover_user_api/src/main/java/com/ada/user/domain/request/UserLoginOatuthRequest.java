package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * 用户通过第三方登陆对象
 * Created by ada on 2017/6/29.
 */
public class UserLoginOatuthRequest extends RequestTokenObject {
    /**
     * 第三方登陆类型
     */
    String type;

    String accessToken;

    String openId;


    public String getType() {
        return type;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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
}
