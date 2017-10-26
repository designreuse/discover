package com.ada.site.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 移动端app
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "site_app")
public class App extends AbstractEntity {

	/**
	 * 程序名称
	 */
	private String name;

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
	 * 程序包名称
	 */
	@Column(unique = true)
	private String packageName;

	/**
	 * 程序下载地址
	 */
	private String downUrl;

	/**
	 * 程序key
	 */
	private String appKey;


	/**
	 * 程序密钥
	 */
	private String appSecret;

	/**
	 * 访问数量
	 */
	private Long counts;
	
	
	/**
	 * 系统
	 */
	private String system="android";
	
	@OrderBy("versionCode DESC")
	@OneToMany(mappedBy="app",fetch=FetchType.LAZY)
	private List<AppVersion> versions;

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDownUrl() {
		return downUrl;
	}

	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

	public List<AppVersion> getVersions() {
		return versions;
	}

	public void setVersions(List<AppVersion> versions) {
		this.versions = versions;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public Long getCounts() {
		return counts;
	}

	public void setCounts(Long counts) {
		this.counts = counts;
	}
}
