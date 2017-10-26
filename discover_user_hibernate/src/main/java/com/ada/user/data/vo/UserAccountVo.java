package com.ada.user.data.vo;

import com.ada.data.rest.domain.AbstractVo;

/**
 * @author 陈联高
 * @version 1.01 2017年03月109日
 */
public class UserAccountVo extends AbstractVo {

    /**
     * 账号id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long user;

    /**
     * 用户令牌
     */
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccountVo)) return false;

        UserAccountVo that = (UserAccountVo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
