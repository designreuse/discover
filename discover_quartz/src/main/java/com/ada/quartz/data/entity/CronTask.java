package com.ada.quartz.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.data.enums.State;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "task")
public class CronTask extends AbstractEntity {

	/**
	 * 任务名称
	 */
	private String name;


	/**
	 * 表达式
	 */
	private String cron;

	/**
	 * url
	 */
	private String url;

	/**
	 * 执行数量
	 */
	private String note;

	/**
	 * 执行数量
	 */
	private Long nums;

	/**
	 * 是否开启日志功能 on是off不是
	 */
	private State recordState;
	/**
	 * 添加用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 0停止 1运行
	 */
	private Integer state;

	/** 属性 */
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "task_attribute", joinColumns = { @JoinColumn(name = "task_id") })
	@MapKeyColumn(name = "name", length = 36)
	@Column(name = "attr", length = 100)
	private Map<String, String> attributes = new HashMap<String, String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getNums() {
		return nums;
	}

	public void setNums(Long nums) {
		this.nums = nums;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public State getRecordState() {
		return recordState;
	}

	public void setRecordState(State recordState) {
		this.recordState = recordState;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}
}
