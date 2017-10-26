package com.ada.album.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "album_category")
public class Category implements Serializable{

	@Id
	private String id;

	private Integer count;

	private String icover;

	private String rname;
	private Long atime;
	private String cover_temp;
	private String name;
	private String cover;
	private Integer rank;
	private Integer type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getIcover() {
		return icover;
	}
	public void setIcover(String icover) {
		this.icover = icover;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Long getAtime() {
		return atime;
	}
	public void setAtime(Long atime) {
		this.atime = atime;
	}
	public String getCover_temp() {
		return cover_temp;
	}
	public void setCover_temp(String cover_temp) {
		this.cover_temp = cover_temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", count=" + count + ", icover=" + icover
				+ ", rname=" + rname + ", atime=" + atime + ", cover_temp="
				+ cover_temp + ", name=" + name + ", conver=" + cover
				+ ", rank=" + rank + ", type=" + type + "]";
	}


}
