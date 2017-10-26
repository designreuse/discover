package com.ada.web.data.entity;


import com.ada.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "site_config")
public class WebConfig  extends AbstractEntity{

    /**
     * 网站标题
     */
    private String title;


    /**
     * 关键词
     */
    private String keywords;


    /**
     * 网站描述
     */
    private String description;


    /**
     * 网站logo
     */
    private String favicon;


    /**
     * 网站logo
     */
    private String logo;


    /**
     * 主题模块
     */
    private String theme;


    /**
     * 域名
     */
    private String domainName;

    private String shortName;


    /**
     * 备案号
     */
    private String icp;

    /**
     * 分页大小
     */
    private Integer pageSize;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
