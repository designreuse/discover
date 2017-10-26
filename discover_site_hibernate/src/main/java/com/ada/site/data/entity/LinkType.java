package com.ada.site.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;

/**
 *  链接分类
 *
 * Created by ada on 2017/6/7.
 */


@Entity
@Table(name = "site_link_type")
public class LinkType extends CatalogEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private LinkType parent;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }

    public LinkType getParent() {
        return parent;
    }

    public void setParent(LinkType parent) {
        this.parent = parent;
    }
}
