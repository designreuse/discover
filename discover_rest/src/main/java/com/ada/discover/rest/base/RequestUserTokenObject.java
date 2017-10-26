package com.ada.discover.rest.base;

/**
 * Created by ada on 2017/7/22.
 */
public class RequestUserTokenObject extends RequestTokenObject {

    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
