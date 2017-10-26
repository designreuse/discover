package com.ada.data.entity;

import javax.persistence.MappedSuperclass;

/**
 * 带有状态的实体
 * 
 * @author ada
 *
 */
@MappedSuperclass
public class BaseStateEntity extends BaseEntity {

	/**
	 * 0为正常1为删除
	 */
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
