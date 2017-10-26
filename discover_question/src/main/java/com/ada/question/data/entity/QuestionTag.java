package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question_tag")
public class QuestionTag extends AbstractEntity {

	
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
		QuestionTag other = (QuestionTag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Column(unique=true)
	private String name;
	


	private int nums;




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public int getNums() {
		return nums;
	}


	public void setNums(int nums) {
		this.nums = nums;
	}

}
