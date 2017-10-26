package com.ada.site.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * app的版本号
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "site_app_version")
public class AppVersion extends AbstractEntity {

	/**
	 * 版本数字版本
	 */
	private Integer versionCode;

	/**
	 * 版本名称
	 */
	private String versionName;

	/**
	 * 程序描述
	 */
	private String note;
	
	/**
	 * 该程序下载地址
	 */
	private String downUrl;

	/**
	 * 对应的程序
	 */
	@ManyToOne
	private App app;
	
	
	public String getDownUrl() {
		return downUrl;
	}

	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

	public Integer getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

}
