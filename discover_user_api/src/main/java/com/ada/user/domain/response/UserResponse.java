package com.ada.user.domain.response;

import com.ada.discover.rest.base.ResponseObject;

/**
 * Created by ada on 2017/6/29.
 */
public class UserResponse extends ResponseObject {

    /**
     * 用户令牌
     */
    private String userToken;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号码
     */
    private String phone;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
