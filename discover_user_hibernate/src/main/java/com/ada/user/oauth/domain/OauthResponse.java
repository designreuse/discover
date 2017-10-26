package com.ada.user.oauth.domain;

import java.io.Serializable;

/**
 * Created by ada on 2017/7/20.
 */
public interface OauthResponse  {

    /**
     * 獲取openid
     *
     * @return
     */
    String getOpenid();

    String  getName();

    String getAvatar();

}
