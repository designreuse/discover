package com.ada.bbs.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * 对帖子点赞
 * Created by cng19 on 2017/6/22.
 */


@Entity
@Table(name = "bbs_froum_post_like")
public class ForumPostLike  extends AbstractEntity {

    /**
     * 帖子
     */
    @OneToOne(fetch = FetchType.LAZY)
    private ForumPost post;

    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    public ForumPost getPost() {
        return post;
    }

    public void setPost(ForumPost post) {
        this.post = post;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
