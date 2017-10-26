package com.ada.article.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * 敏感词
 * 
 * @author 年高
 *
 */

@Entity
@Table(name = "article_sensitive_word")
public class SensitiveWord extends AbstractEntity {

	/**
	 * 敏感词
	 */
	private String word;

	/**
	 * 替换词
	 */
	@Column(name="replace_word")
	private String replace;

	/**
	 * 分类
	 */
	private Integer catalog;

	/**
	 * 用户
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo user;

	/**
	 * 相关类容一共有多少个敏感词
	 */
	@Column(name="word_size")
	private Integer size;

	
	
	
	/**
	 * 敏感词分类
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private SensitiveCategory category;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getReplace() {
		return replace;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}

	public Integer getCatalog() {
		return catalog;
	}

	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public SensitiveCategory getCategory() {
		return category;
	}

	public void setCategory(SensitiveCategory category) {
		this.category = category;
	}

}
