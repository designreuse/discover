package com.ada.album.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album_album")
public class Album extends AbstractEntity {


	private String name;

	@ManyToOne()
	private UserInfo user;



	public String getName() {
		return name;
	}

	public UserInfo getUser() {
		return user;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
