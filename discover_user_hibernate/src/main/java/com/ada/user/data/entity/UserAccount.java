package com.ada.user.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.enums.AccountType;

import javax.persistence.*;

/**用户账号
 *
 * Created by ada on 2016/12/20.
 */

@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractEntity {

    /**
     * 账号类型
     */
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    /**
     * 登陆次数
     */
    private Integer loginSize;

    /**
     * 密码
     */
    @Column(length = 50)
    private String password;

    /**
     * 盐
     */
    @Column(length = 50)
    private String salt;

    /**
     * 用户信息
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo user;


    /**
     * 用户名
     */
    @Column(length = 50,unique =true)
    private String username;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Integer getLoginSize() {
        return loginSize;
    }

    public void setLoginSize(Integer loginSize) {
        this.loginSize = loginSize;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
