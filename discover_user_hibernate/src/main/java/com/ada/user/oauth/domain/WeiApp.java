package com.ada.user.oauth.domain;

/**
 * Created by ada on 2017/7/21.
 */
public class WeiApp implements OauthResponse {

    private String openid;

    private String session_key;

    private Integer expires_in;

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String getOpenid() {
        return openid;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getAvatar() {
        return "";
    }
}
