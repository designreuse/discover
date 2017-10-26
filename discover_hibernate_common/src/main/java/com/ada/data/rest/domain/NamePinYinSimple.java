package com.ada.data.rest.domain;

import java.io.Serializable;

/**
 * 名字+id 对象
 * 
 * @author 73552
 *
 */
public class NamePinYinSimple implements Serializable {

	/**
	 * 数据id
	 */
	private Long id;

	/**
	 * 数据名称
	 * 
	 */
	private String name;

	/**
	 * 拼音头字母
	 */
	private String headChar;

	/**
	 * 状态
	 */
	private Integer state;
	
	
	

	public String getHeadChar() {
		return headChar;
	}

	public void setHeadChar(String headChar) {
		this.headChar = headChar;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
