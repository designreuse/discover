package com.ada.activity.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 活动
 * 
 * @author 年高
 *
 */

@Entity
@Table(name = "activity")
public class Activity extends AbstractEntity {
	
	
	@Column(length=120)
	private String name;
	
	@Column(length=65536)
	private String note;

	@ManyToOne
	private ActivityCatalog catalog;
	
	
	@ManyToOne
	private UserInfo user;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public ActivityCatalog getCatalog() {
		return catalog;
	}


	public void setCatalog(ActivityCatalog catalog) {
		this.catalog = catalog;
	}


	public UserInfo getUser() {
		return user;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	

}
