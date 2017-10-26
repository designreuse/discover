package com.ada.user.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;


@Entity
@Table(name = "user_role_catalog")
public class UserRoleCatalog extends CatalogEntity {


    /**
     * 父id
     */
    @JoinColumn(name = "pid")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRoleCatalog parent;

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }

    public UserRoleCatalog getParent() {
        return parent;
    }

    public void setParent(UserRoleCatalog parent) {
        this.parent = parent;
    }
}
