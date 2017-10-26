package com.ada.article.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 文章
 *
 * @author 年高
 */
@Entity
@Table(name = "article")
public class Article extends AbstractEntity {


    @ManyToOne
    private ArticleCatalog catalog;
    /**
     * 文章评论数量
     */
    private Integer comments;
    private String contents;
    private String exts;
    private String images;
    private String img;
    private String introduction;
    @JoinTable(name = "article_link_tag")
    @ManyToMany
    private Set<ArticleTag> tags;
    private String title;
    private Integer ups;
    @ManyToOne()
    private UserInfo user;
    /**
     * 文章查看数量
     */
    private Integer views;


    public ArticleCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ArticleCatalog catalog) {
        this.catalog = catalog;
    }

    public Integer getComments() {
        if (comments == null) {
            comments = 0;
        }
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Set<ArticleTag> getTags() {
        if (tags == null) {
            tags = new HashSet<ArticleTag>();
        }
        return tags;
    }

    public void setTags(Set<ArticleTag> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUps() {
        if (ups == null) {
            ups = 0;
        }
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
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

    @Override
    public String toString() {
        return "Article [catalog=" + catalog + ", user=" + user
                + ", introduction=" + introduction + ", tags=" + tags + ", title=" + title + ", exts=" + exts
                + ", images=" + images + ", ups=" + ups + ", comments=" + comments + ", views=" + views + "]";
    }

}
