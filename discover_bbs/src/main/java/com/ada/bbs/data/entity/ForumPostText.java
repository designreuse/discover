package com.ada.bbs.data.entity;

import com.ada.data.entity.LongEntity;

import javax.persistence.*;

/**
 * 帖子的具体内容
 * Created by cng19 on 2017/6/22.
 */
@Entity
@Table(name = "bbs_froum_post_text")
public class ForumPostText extends LongEntity {

    /**
     * 帖子内容
     */
    @Column(length = 10000)
    private String note;

    /**
     * 帖子
     */
    @OneToOne(fetch = FetchType.LAZY)
    private ForumPost post;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ForumPost getPost() {
        return post;
    }

    public void setPost(ForumPost post) {
        this.post = post;
    }
}
