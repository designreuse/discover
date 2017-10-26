package com.ada.shiro.realm;

import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * Created by ada on 2017/6/9.
 */
public class AuthToken  implements RememberMeAuthenticationToken {
    private String ticket = null;
    private String userId = null;
    private boolean isRememberMe = false;

    public AuthToken(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 当事人
     *
     * @return
     */
    public Object getPrincipal() {
        return this.userId;
    }

    /**
     * 凭据
     * @return
     */
    public Object getCredentials() {
        return this.ticket;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isRememberMe() {
        return this.isRememberMe;
    }

    public void setRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }
}
