package com.ada.question.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question_points")
public class QuestionPoints extends AbstractEntity {

	@ManyToOne
	private UserInfo user;

	private Integer points;
	
	private Integer qposts;
	private Integer aposts;
	private Integer cposts;
	private Integer aselects;
	private Integer aselecteds;
	private Integer qupvotes;
	private Integer qdownvotes;
	private Integer aupvotes;
	private Integer adownvotes;
	private Integer qvoteds;
	private Integer avoteds;
	private Integer upvoteds;
	private Integer downvoteds;
	private Integer bonus;
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getQposts() {
		return qposts;
	}
	public void setQposts(Integer qposts) {
		this.qposts = qposts;
	}
	public Integer getAposts() {
		return aposts;
	}
	public void setAposts(Integer aposts) {
		this.aposts = aposts;
	}
	public Integer getCposts() {
		return cposts;
	}
	public void setCposts(Integer cposts) {
		this.cposts = cposts;
	}
	public Integer getAselects() {
		return aselects;
	}
	public void setAselects(Integer aselects) {
		this.aselects = aselects;
	}
	public Integer getAselecteds() {
		return aselecteds;
	}
	public void setAselecteds(Integer aselecteds) {
		this.aselecteds = aselecteds;
	}
	public Integer getQupvotes() {
		return qupvotes;
	}
	public void setQupvotes(Integer qupvotes) {
		this.qupvotes = qupvotes;
	}
	public Integer getQdownvotes() {
		return qdownvotes;
	}
	public void setQdownvotes(Integer qdownvotes) {
		this.qdownvotes = qdownvotes;
	}
	public Integer getAupvotes() {
		return aupvotes;
	}
	public void setAupvotes(Integer aupvotes) {
		this.aupvotes = aupvotes;
	}
	public Integer getAdownvotes() {
		return adownvotes;
	}
	public void setAdownvotes(Integer adownvotes) {
		this.adownvotes = adownvotes;
	}
	public Integer getQvoteds() {
		return qvoteds;
	}
	public void setQvoteds(Integer qvoteds) {
		this.qvoteds = qvoteds;
	}
	public Integer getAvoteds() {
		return avoteds;
	}
	public void setAvoteds(Integer avoteds) {
		this.avoteds = avoteds;
	}
	public Integer getUpvoteds() {
		return upvoteds;
	}
	public void setUpvoteds(Integer upvoteds) {
		this.upvoteds = upvoteds;
	}
	public Integer getDownvoteds() {
		return downvoteds;
	}
	public void setDownvoteds(Integer downvoteds) {
		this.downvoteds = downvoteds;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

}
