package com.ada.area.data.entity;

import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "area")
public class Area extends CatalogEntity {
    /**
     * 下属地区
     */
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Area> childrens;
    /**
     * 父地区id
     */
    @JoinColumn(name = "pid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area parent;
    /**
     * 城市状态 1为开通，0为未开通
     */
    private Integer state;

    private String geo;

    /**
     * 地理经度。
     */
    private Float lng;


    /**
     * 地理纬度。
     */
    private Float lat;

    @Column(name = "area_type")
    private Integer type;

    /**
     * 政府编码
     */
    @Column(length = 12)
    private String govCode;


    public List<Area> getChildrens() {
        if (childrens != null && childrens.size() > 0) {
            return childrens;

        } else {
            return null;

        }
    }

    public void setChildrens(List<Area> childrens) {
        this.childrens = childrens;
    }


    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public Integer getParentId() {
        Area parent = getParent();
        if (parent != null) {
            return parent.getId();
        } else {
            return null;
        }
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Area{" +
                "type=" + type +
                "name=" + getName() +
                "code=" + getCode() +
                '}';
    }

    public String getGovCode() {
        return govCode;
    }

    public void setGovCode(String govCode) {
        this.govCode = govCode;
    }
}
