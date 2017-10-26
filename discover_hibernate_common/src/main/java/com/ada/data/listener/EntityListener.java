package com.ada.data.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.ada.data.entity.AbstractEntity;

/**
 * Listener - 创建日期、修改日期处理
 * 
 * 
 * 
 */
public class EntityListener {

	/**
	 * 保存前处理
	 * 
	 * @param entity
	 *            基类
	 */
	@PrePersist
	public void prePersist(AbstractEntity entity) {
		entity.setLastDate(new Date());
	}

	/**
	 * 更新前处理
	 * 
	 * @param entity
	 *            基类
	 */
	@PreUpdate
	public void preUpdate(AbstractEntity entity) {
		entity.setLastDate(new Date());
	}

}