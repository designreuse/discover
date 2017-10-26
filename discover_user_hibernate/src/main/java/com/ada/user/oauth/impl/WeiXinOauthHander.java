package com.ada.user.oauth.impl;

import com.ada.user.oauth.api.OauthHander;
import com.ada.user.oauth.domain.UserWeiXin;
import com.ada.utils.http.Connection;
import com.ada.utils.http.HttpConnection;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by ada on 2017/6/29.
 */
public class WeiXinOauthHander implements OauthHander {
    /**
     * @param element
     * @return
     */
    private String getString(JsonElement element, String key) {

        String result = "";
        try {
            result = element.getAsJsonObject().get(key).getAsString();
        } catch (Exception e2) {
        }

        return result;
    }

    private Integer getInt(JsonElement element, String key) {

        Integer result = 0;
        try {
            result = element.getAsJsonObject().get(key).getAsInt();
        } catch (Exception e2) {
        }
        return result;
    }

    private String   oauth_consumer_key;


    public void setKey(String oauth_consumer_key) {
        this.oauth_consumer_key = oauth_consumer_key;
    }

    @Override
    public void setSecret(String secret) {

    }

    public UserWeiXin login(String access_token, String openid) {
        UserWeiXin weixin=null;
        try {
            Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/userinfo");
            con.data("access_token", access_token);
            con.data("openid", openid);
            String body;
            body = con.execute().body();

             weixin = new UserWeiXin();
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(body);
            String nickname = getString(element, "nickname");
            weixin.setNickName(nickname);
            String headimgurl = getString(element, "headimgurl");
            weixin.setHeadimgurl(headimgurl);
            String city = getString(element, "city");
            weixin.setCity(city);
            Integer sexid = getInt(element, "sex");
            String sex = "男";
            if (sexid == null || sexid == 0) {
                sex = "女";
            }
            weixin.setSex(sex);
            String province = getString(element, "province");
            weixin.setProvince(province);
            String country = getString(element, "country");
            weixin.setCountry(country);
            weixin.setUnionid(getString(element, "unionid"));
            weixin.setAccessToken(access_token);
            weixin.setOpenid(openid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return weixin;

    }
}
