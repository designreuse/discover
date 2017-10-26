package com.ada.data.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;




@MappedSuperclass
public class UUIDEntity implements Serializable{
	
	
	/**
	 *  数据库主键
	 */
	@Id
	private String id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UUIDEntity other = (UUIDEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
