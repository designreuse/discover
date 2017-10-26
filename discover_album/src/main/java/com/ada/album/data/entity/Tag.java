package com.ada.album.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "album_tag")
public class Tag implements Serializable{

	private Date addDate;

	private Date lastDate;

	public static Tag fromName(String name){
		Tag tag=new Tag();
		tag.setName(name);
		return tag;
	}
	
	
	private String url;
	
	@Id
	private String name;

	public Date getAddDate() {
		return addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
