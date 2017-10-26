package com.ada.site.domain.request;

import com.ada.discover.rest.base.RequestObjectBase;

/**
 * Created by ada on 2017/5/16.
 */
public class AppRequest extends RequestObjectBase {

    private String appKey;

    private String appSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
