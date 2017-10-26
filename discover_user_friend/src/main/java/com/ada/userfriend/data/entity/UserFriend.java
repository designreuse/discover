package com.ada.userfriend.data.entity;

import com.ada.data.entity.BaseEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_friend")
public class UserFriend extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserInfo user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "friendid")
	private UserInfo friend;

	/**
	 * 1是申请 2是同意
	 */
	private Integer state;

	private Date addDate;

	private Date lastDate;

	/**
	 * 备注
	 */
	private String note;

	public Date getAddDate() {
		return addDate;
	}

	public UserInfo getFriend() {
		return friend;
	}

	public String getNote() {
		return note;
	}

	public Integer getState() {
		return state;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setFriend(UserInfo friend) {
		this.friend = friend;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
