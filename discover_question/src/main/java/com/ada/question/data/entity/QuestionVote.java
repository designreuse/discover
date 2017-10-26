package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 回答投票
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "question_vote")
public class QuestionVote extends AbstractEntity {


	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne()
	private UserInfo user;

	/**
	 * 问题的回答
	 */
	@JoinColumn
	@ManyToOne()
	private Question question;
	
	/**
	 * 投票数量
	 */
	private Integer vote;
	
	/**
	 * 投票类型
	 */
	private Integer flag;


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getFlag() {
		return flag;
	}


	public UserInfo getUser() {
		return user;
	}


	public Integer getVote() {
		return vote;
	}


	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}
	
	
}
