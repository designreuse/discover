package com.ada.site.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity - 配置版本管理
 * 
 */
@Entity
@Table(name = "config_data_version")
public class SystemVersion extends AbstractEntity {

	/**
	 * 最高版本数据
	 */
	@Column(unique = true)
	private Long versionnum;

	/**
	 * 版本数据
	 */
	private String sequence;

	/**
	 * 步长 默认为1
	 */
	private Integer step;

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Integer getStep() {
		if (step == null) {
			return 1;
		}
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Long getVersionnum() {
		return versionnum;
	}

	public void setVersionnum(Long versionnum) {
		this.versionnum = versionnum;
	}

}
