package com.ada.data.rest.domain;

import java.io.Serializable;

/**
 * 名字+id 对象
 * 
 * @author 73552
 *
 */
public class NameSimple implements Serializable {

	/**
	 * 数据id
	 */
	private Long id;

	/**
	 * 数据名称
	 * 
	 */
	private String name;

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
