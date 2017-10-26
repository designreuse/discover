package com.ada.bbs.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用戶喜欢的论坛
 * Created by cng19 on 2017/6/22.
 */


@Entity
@Table(name = "bbs_froum_like")
public class ForumLike extends AbstractEntity {

    /**
     * 论坛模块
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Forum forum;


    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
