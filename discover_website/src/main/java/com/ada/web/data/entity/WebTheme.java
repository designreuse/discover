package com.ada.web.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.data.entity.UUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "site_theme_config")
public class WebTheme extends UUIDEntity {

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String path;

    /**
     * 图片路径
     */
    private String screenShot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getScreenShot() {
        return screenShot;
    }

    public void setScreenShot(String screenShot) {
        this.screenShot = screenShot;
    }
}
