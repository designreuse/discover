/*
 * 
 * 
 * 
 */
package com.ada.ad.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.data.entity.CatalogEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity - 广告位
 * 
 * 
 * 
 */
@Entity
@Table(name = "ad_position")
public class AdPosition extends CatalogEntity {

	private static final long serialVersionUID = -7849848867030199578L;

	public AdPosition(){
		width=1;
		height=1;
		template="";
	}
	/** 名称 */
	@Column(nullable = false)
	private String name;

	/** 宽度 */
	@Column(nullable = false)
	private Integer width;

	/** 高度 */
	@Column(nullable = false)
	private Integer height;

	/** 描述 */
	private String description;

	/** 模板 */
	@Lob
	@Column(nullable = false)
	private String template;

	@ManyToOne(fetch = FetchType.LAZY)
	private AdPosition parent;

	/** 广告 */
	@OneToMany(mappedBy = "adPosition", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("adPosition asc")
	private Set<Ad> ads = new HashSet<Ad>();

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */

	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取宽度
	 * 
	 * @return 宽度
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * 设置宽度
	 * 
	 * @param width
	 *            宽度
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 获取高度
	 * 
	 * @return 高度
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * 设置高度
	 * 
	 * @param height
	 *            高度
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * 获取描述
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述
	 * 
	 * @param description
	 *            描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取模板
	 * 
	 * @return 模板
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * 设置模板
	 * 
	 * @param template
	 *            模板
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * 获取广告
	 * 
	 * @return 广告
	 */
	public Set<Ad> getAds() {
		return ads;
	}

	/**
	 * 设置广告
	 * 
	 * @param ads
	 *            广告
	 */
	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}

	@Override
	public Integer getParentId() {
		if (parent!=null){
			return parent.getId();
		}
		return null;
	}

	public AdPosition getParent() {
		return parent;
	}

	public void setParent(AdPosition parent) {
		this.parent = parent;
	}
}