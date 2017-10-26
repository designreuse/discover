package com.ada.user.oauth.api;

import com.ada.user.oauth.domain.OauthResponse;
import com.ada.user.oauth.domain.UserQQ;

/**
 * Created by ada on 2017/7/20.
 */
public interface OauthHander {

    void setKey(String key);

    void setSecret(String secret);

    OauthResponse login(String access_token, String openid);

}
