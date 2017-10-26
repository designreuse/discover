package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;

/**
 * 回答投票
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "question_answer_vote")
public class QuestionAnswerVote extends AbstractEntity{


	/**
	 * 用户
	 */
	@JoinColumn(name = "userid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	/**
	 * 问题的回答
	 */
	@JoinColumn
	@ManyToOne(fetch = FetchType.LAZY)
	private QuestionAnswer answer;
	
	/**
	 * 投票数量
	 */
	private Integer vote;
	
	/**
	 * 投票类型
	 */
	private Integer flag;

	public QuestionAnswer getAnswer() {
		return answer;
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

	public void setAnswer(QuestionAnswer answer) {
		this.answer = answer;
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
