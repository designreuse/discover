/*
 * 
 * 
 * 
 */
package com.ada.ad.data.entity;

import com.ada.ad.data.enums.AdType;
import com.ada.data.entity.SortEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity - 广告
 * 
 * 
 * 
 */
@Entity
@Table(name = "ad")
public class Ad extends SortEntity {

	private static final long serialVersionUID = -1307743303786909390L;


	/** 标题 */
	private String title;

	/** 类型 */
	private AdType type;

	/** 路径 */
	private String path;

	/** 起始日期 */
	private Date beginDate;

	/** 结束日期 */
	private Date endDate;

	/** 链接地址 */
	private String url;

	/** 广告位 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private AdPosition adPosition;

	/**
	 * 获取广告位
	 * 
	 * @return 广告位
	 */
	public AdPosition getAdPosition() {
		return adPosition;
	}

	/**
	 * 获取起始日期
	 * 
	 * @return 起始日期
	 */
	public Date getBeginDate() {
		return beginDate;
	}


	/**
	 * 获取结束日期
	 * 
	 * @return 结束日期
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 获取路径
	 * 
	 * @return 路径
	 */
	public String getPath() {
		return path;
	}

	public String getTitle() {
		return title;
	}

	public AdType getType() {
		return type;
	}

	/**
	 * 获取链接地址
	 * 
	 * @return 链接地址
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * 判断是否已开始
	 * 
	 * @return 是否已开始
	 */
	@Transient
	public boolean hasBegun() {
		return getBeginDate() == null || new Date().after(getBeginDate());
	}

	/**
	 * 判断是否已结束
	 * 
	 * @return 是否已结束
	 */
	@Transient
	public boolean hasEnded() {
		return getEndDate() != null && new Date().after(getEndDate());
	}

	/**
	 * 设置广告位
	 * 
	 * @param adPosition
	 *            广告位
	 */
	public void setAdPosition(AdPosition adPosition) {
		this.adPosition = adPosition;
	}

	/**
	 * 设置起始日期
	 * 
	 * @param beginDate
	 *            起始日期
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}


	/**
	 * 设置结束日期
	 * 
	 * @param endDate
	 *            结束日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 设置路径
	 * 
	 * @param path
	 *            路径
	 */
	public void setPath(String path) {
		this.path = path;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(AdType type) {
		this.type = type;
	}

	/**
	 * 设置链接地址
	 * 
	 * @param url
	 *            链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}