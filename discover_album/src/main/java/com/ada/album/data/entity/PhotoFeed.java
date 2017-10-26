package com.ada.album.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "album_feed")
public class PhotoFeed extends AbstractEntity{

	@ManyToOne()
	private UserInfo user;
	
	
	@ManyToMany
	@JoinTable(name="album_photo_feeds")
	private Set<Photo> photos=new HashSet<Photo>();
	
	
	private String url;
	
	private String name;


	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public UserInfo getUser() {
		return user;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}


	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
}
