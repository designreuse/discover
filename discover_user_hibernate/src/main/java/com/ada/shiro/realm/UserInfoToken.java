package com.ada.shiro.realm;

import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * Created by ada on 2017/6/9.
 */
public class UserInfoToken implements RememberMeAuthenticationToken {
    private Long user = null;
    private boolean isRememberMe = false;

    public UserInfoToken( Long user ) {
        this.user = user;
    }

    /**
     * 当事人
     *
     * @return
     */
    public Object getPrincipal() {
        return this.user;
    }

    /**
     * 凭据
     * @return
     */
    public Object getCredentials() {
        return this.user;
    }


    public boolean isRememberMe() {
        return this.isRememberMe;
    }

    public void setRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }
}
