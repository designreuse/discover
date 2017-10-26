package com.ada.bbs.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * Created by cng19 on 2017/6/22.
 */


@Entity
@Table(name = "bbs_froum_post_comment")
public class ForumPostComment extends AbstractEntity{


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

    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
