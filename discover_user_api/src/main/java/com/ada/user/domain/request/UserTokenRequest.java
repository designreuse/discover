package com.ada.user.domain.request;

import com.ada.discover.rest.base.RequestTokenObject;

/**
 * Created by ada on 2017/7/4.
 */
public class UserTokenRequest  extends RequestTokenObject {

    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
