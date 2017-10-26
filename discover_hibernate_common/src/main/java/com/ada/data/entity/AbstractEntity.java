package com.ada.data.entity;

import com.ada.data.listener.EntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


@EntityListeners(EntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity extends LongEntity implements Serializable{


	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 最新修改时间
	 */
	private Date lastDate;
	
	public AbstractEntity(){
		inittime();
		
	}


	private void inittime() {
		addDate=new Date();
		lastDate=new Date();
	}


	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	
}
