package com.ada.user.domain.request;

/**
 * Created by ada on 2017/7/4.
 */
public class UserChangePasswordRequestion extends UserTokenRequest {

    private String oldPassword;

    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
