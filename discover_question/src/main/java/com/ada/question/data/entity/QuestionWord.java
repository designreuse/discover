package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 问题分词
 * 
 * @author ada
 *
 */

@Entity
@Table(name = "question_word")
public class QuestionWord extends AbstractEntity {

	/**
	 * 词语
	 */
	private String word;

	/**
	 * 标题数量
	 */
	@Column(name = "titlecount")
	private Integer titleCount;

	/**
	 * 内容数量
	 */
	@Column(name = "contentcount")
	private Integer contentCount;

	/**
	 * 标签数量
	 */
	@Column(name = "tagwordcount")
	private Integer tagwordCount;

	/**
	 * 标签数量
	 */
	@Column(name = "tagcount")
	private Integer tagCount;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getTitleCount() {
		return titleCount;
	}

	public void setTitleCount(Integer titleCount) {
		this.titleCount = titleCount;
	}

	public Integer getContentCount() {
		return contentCount;
	}

	public void setContentCount(Integer contentCount) {
		this.contentCount = contentCount;
	}

	public Integer getTagwordCount() {
		return tagwordCount;
	}

	public void setTagwordCount(Integer tagwordCount) {
		this.tagwordCount = tagwordCount;
	}

	public Integer getTagCount() {
		return tagCount;
	}

	public void setTagCount(Integer tagCount) {
		this.tagCount = tagCount;
	}

}
