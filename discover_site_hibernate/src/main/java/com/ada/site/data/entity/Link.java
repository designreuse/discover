package com.ada.site.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.*;

/**
 * 友情链接
 * Created by ada on 2017/6/7.
 */


@Entity
@Table(name = "site_link")
public class Link extends AbstractEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    private LinkType linkType;

    /**
     * 名称
     */
    @Column(length = 50)
    private String name;

    /**
     * 链接
     */
    private String url;

    /**
     * 链接打开方式
     * _blank 新窗口
     * _self 当前窗口
     * _parent 父窗口
     * _top
     */
    private String target;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序号码
     */
    private Integer sortNum;

    public LinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}
