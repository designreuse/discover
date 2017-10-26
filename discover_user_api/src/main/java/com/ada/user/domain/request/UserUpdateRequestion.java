package com.ada.user.domain.request;

/**
 * Created by ada on 2017/7/4.
 */
public class UserUpdateRequestion extends UserTokenRequest {

    private String name;

    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
