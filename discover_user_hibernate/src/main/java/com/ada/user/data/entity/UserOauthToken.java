package com.ada.user.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户oauth登陆信息
 * 
 * @author 73552
 *
 */
@Entity
@Table(name = "user_oauth_token")
public class UserOauthToken extends AbstractEntity {

	/**
	 * 访问token
	 */
	private String access_token;
	/**
	 * 刷新token
	 */
	private String refresh_token;

	/**
	 * token类型
	 */
	private String token_type;

	/**
	 * 用户id
	 * 
	 */
	private String uid;

	
	/**
	 * 过期时间
	 * 
	 */
	private Long expires_in;
	
	/**
	 * 和用户绑定
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private UserInfo user;
	
	private Integer loginSize;

	public Integer getLoginSize() {
		return loginSize;
	}

	public void setLoginSize(Integer loginSize) {
		this.loginSize = loginSize;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

}
