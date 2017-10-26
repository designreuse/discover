package com.ada.user.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单实体
 *
 * @author ada
 */

@Entity
@Table(name = "menu")
public class Menu extends CatalogEntity {

    /**
     * 分类 0为菜单1为功能
     */
    private Integer catalog;
    /**
     * 子菜单
     */
    @OrderBy("sortNum asc")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Menu> childrens;
    /**
     * 图标
     */
    private String icon;
    /**
     * 子节点数量
     */
    private Long nums;
    /**
     * 父分类
     */
    @JoinColumn(name = "pid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parent;
    /**
     * url地址
     */
    private String path;

    /**
     * 该功能的权限
     */
    private String permission;

    public Integer getCatalog() {
        if (catalog == null) {
            return 0;
        }
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public List<Menu> getChildrens() {
        if (childrens != null && childrens.size() > 0) {
            return childrens;

        } else {
            return null;

        }
    }

    public void setChildrens(List<Menu> childrens) {
        this.childrens = childrens;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getMenus() {
        if (childrens != null && childrens.size() > 0) {
            List<Menu> menus = new ArrayList<Menu>();
            for (Menu menu : childrens) {
                if (menu.getCatalog() == 0) {
                    menus.add(menu);
                }
            }
            if (menus.size() > 0) {
                return menus;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Long getNums() {
        if (nums == null) {
            return 0l;
        }
        return nums;
    }

    public void setNums(Long nums) {
        this.nums = nums;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public Integer getParentId() {
        if (parent != null) {
            return parent.getId();
        } else {
            return null;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取权限，要是没有设置，用id当权限
     *
     * @return
     */
    public String getPermission() {
        if (permission == null || permission.length() < 1) {
            return "" + getId();
        } else {
            return permission;
        }
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
