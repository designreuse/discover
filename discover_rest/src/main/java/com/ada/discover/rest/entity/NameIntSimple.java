package com.ada.discover.rest.entity;

import java.io.Serializable;

/**
 * 名字+id 对象
 * 
 * @author 73552
 *
 */
public class NameIntSimple implements Serializable {

	/**
	 * 数据id
	 */
	private Integer id;

	/**
	 * 数据名称
	 * 
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
