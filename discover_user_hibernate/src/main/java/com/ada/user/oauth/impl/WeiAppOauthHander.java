package com.ada.user.oauth.impl;

import com.ada.user.oauth.api.OauthHander;
import com.ada.user.oauth.domain.UserWeiXin;
import com.ada.user.oauth.domain.WeiApp;
import com.ada.utils.http.Connection;
import com.ada.utils.http.HttpConnection;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by ada on 2017/6/29.
 */
public class WeiAppOauthHander implements OauthHander {

    private String   oauth_consumer_key;
    private String   secret;
    public void setKey(String oauth_consumer_key) {
        this.oauth_consumer_key = oauth_consumer_key;
    }

    @Override
    public void setSecret(String secret) {
        this.secret=secret;
    }

    public WeiApp login(String access_token, String openid) {
        WeiApp weixin=null;
        try {
            Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/jscode2session");
            con.data("js_code", access_token);
            con.data("appid", oauth_consumer_key);
            con.data("secret", secret);
            String body;
            body = con.execute().body();
            Gson gson = new Gson();
            weixin=gson.fromJson(body,WeiApp.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weixin;

    }
}
