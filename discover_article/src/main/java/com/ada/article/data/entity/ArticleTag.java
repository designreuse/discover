package com.ada.article.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文章标签
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article_tag")
public class ArticleTag extends AbstractEntity {


	private String name;

	private Integer size;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	
	
	
}
