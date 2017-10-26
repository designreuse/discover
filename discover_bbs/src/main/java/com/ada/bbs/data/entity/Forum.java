package com.ada.bbs.data.entity;

import com.ada.data.entity.CatalogEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * 论坛模块
 *
 * Created by cng19 on 2017/6/22.
 */


@Entity
@Table(name = "bbs_froum")
public class Forum extends CatalogEntity {


    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid")
    private Forum parent;

    public Forum getParent() {
        return parent;
    }

    public void setParent(Forum parent) {
        this.parent = parent;
    }

    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        } else {
            return null;

        }
    }
}
