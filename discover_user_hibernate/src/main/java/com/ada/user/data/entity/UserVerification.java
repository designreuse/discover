package com.ada.user.data.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

/**
 * 用户验证码
 * 
 * @author aniaojian
 *
 */
@Entity
@Table(name = "user_verification")
public class UserVerification extends AbstractEntity {

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 用户
	 */
	private String name;

	/**
	 * 分类
	 */
	private Integer catalog;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
