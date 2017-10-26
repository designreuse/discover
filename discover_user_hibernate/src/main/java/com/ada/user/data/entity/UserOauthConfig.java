package com.ada.user.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ada on 2017/7/20.
 */

@Entity
@Table(name = "user_oauth_config")
public class UserOauthConfig extends AbstractEntity {

    /**
     * 第三方登陆名称
     */
    private String name;


    private String model;


    /**
     * 程序key
     */
    private String appKey;


    /**
     * 程序密钥
     */
    private String appSecret;


    private Integer state;

    private String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
