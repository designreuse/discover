package com.ada.album.data.entity;


import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "album_photo")
public class Photo implements Serializable {

	private Date addDate;

	@ManyToOne()
	private Album album;

	@ManyToOne()
	private Category category;

	@Id
	private String id;

	@Column(unique = true)
	private String img;

	private Date lastDate;

	private String name;

	@ManyToMany
	@JoinTable(name = "album_photo_tags")
	private Set<Tag> tags = new HashSet<Tag>();

	private String thumb;

	private String url;

	@ManyToOne()
	private UserInfo user;

	public Photo() {
		addDate = new Date();
		lastDate = new Date();
	}

	public Date getAddDate() {
		return addDate;
	}

	public Album getAlbum() {
		return album;
	}

	public Category getCategory() {
		return category;
	}

	public String getId() {
		return id;
	}

	public String getImg() {
		return img;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getName() {
		return name;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public String getThumb() {
		return thumb;
	}

	public String getUrl() {
		return url;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + "]";
	}

}
