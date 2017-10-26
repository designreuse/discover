package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 提问回答
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "question_answer")
public class QuestionAnswer extends AbstractEntity {
	

	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;
	
	@JoinColumn
	@ManyToOne()
	private Question question;
	

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 回答内容
	 */
	private String contents;

	/**
	 * 图片集合
	 */
	private String images;

	/**
	 * 支持人数
	 */
	private Integer ups;
	

	/**
	 * 回答是否被采纳
	 */
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getContents() {
		return contents;
	}
	

	public String getImages() {
		return images;
	}

	public Question getQuestion() {
		return question;
	}

	public String getTitle() {
		return title;
	}

	public Integer getUps() {
		return ups;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setImages(String images) {
		this.images = images;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}



	
	
	
}
