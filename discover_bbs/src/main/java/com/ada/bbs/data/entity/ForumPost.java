package com.ada.bbs.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * Created by cng19 on 2017/6/22.
 */


@Entity
@Table(name = "bbs_froum_post")
public class ForumPost extends AbstractEntity{


    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


    @ManyToOne(fetch = FetchType.LAZY)
    private Forum forum;

    @OneToOne(mappedBy = "post",fetch = FetchType.LAZY)
    private ForumPostText postText;

    public ForumPostText getPostText() {
        return postText;
    }

    public void setPostText(ForumPostText postText) {
        this.postText = postText;
    }

    private String name;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}
