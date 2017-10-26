package com.ada.user.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户登录记录
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "user_login_log")
public class UserLoginLog extends AbstractEntity {

	private String ip;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 登录状态，0为失败1为成功
	 */
	private Integer state;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	
}
