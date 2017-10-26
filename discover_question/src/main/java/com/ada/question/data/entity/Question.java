package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * 提问
 *
 * @author ada
 */
@Entity
@Table(name = "question")
public class Question extends AbstractEntity {


    /**
     * 该问题有多少个回答
     */
    private Integer answers;
    /**
     * 问题分类
     */
    @JoinColumn
    @ManyToOne()
    private QuestionCatalog catalog;
    /**
     * 标题
     */
    private String contents;
    /**
     * 该问题有多少个人收藏
     */
    private Integer favorites;
    /**
     * 图片集合
     */
    private String images;
    /**
     * 是否解决
     */
    private Integer state;
    /**
     * 标题
     */
    private String title;
    /**
     * 用户
     */
    @JoinColumn(name = "userid")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;
    /**
     * 该问题有多少个查看
     */
    private Integer views;
    /**
     * 该问题有多少个投票
     */
    private Integer votes;



    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    public QuestionCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(QuestionCatalog catalog) {
        this.catalog = catalog;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }



    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }


}
