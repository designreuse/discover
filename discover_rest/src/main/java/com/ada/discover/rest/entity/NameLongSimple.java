package com.ada.discover.rest.entity;

import com.ada.discover.rest.base.ResponseSimple;

/**
 * 名字+id 对象
 * 
 * @author 73552
 *
 */
public class NameLongSimple implements ResponseSimple {

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
