package com.ada.user.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.data.enums.State;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ada on 2017/7/21.
 */

@MappedSuperclass
public abstract class AbstractUser extends AbstractEntity {


    /** 属性 */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_info_attribute", joinColumns = { @JoinColumn(name = "user_id") })
    @MapKeyColumn(name = "name", length = 36)
    @Column(name = "attr", length = 100)
    private Map<String, String> attributes = new HashMap<String, String>();

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类型
     */
    private Integer catalog;


    /**
     * 手机号码
     */
    @Column(length = 15)
    private String phone;

    /**
     * 用户登录次数
     */
    private Integer loginSize = 0;

    /**
     * 用户真实姓名
     */
    @Column(length = 20)
    private String name;



    /**
     * 注册
     */
    @Column(length = 20)
    private String registerType = "账号";

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_links", joinColumns = { @JoinColumn(name = "user_id") })
    private Set<UserRole> roles = new HashSet<UserRole>();



    /**
     * 用户状态
     */
    @Enumerated()
    private State state;


    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getCatalog() {
        if (catalog == null) {
            return 0;
        }
        return catalog;
    }

    public String getName() {
        return name;
    }



    public String getRegisterType() {
        return registerType;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }



    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Integer getLoginSize() {
        return loginSize;
    }

    public void setLoginSize(Integer loginSize) {
        this.loginSize = loginSize;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
