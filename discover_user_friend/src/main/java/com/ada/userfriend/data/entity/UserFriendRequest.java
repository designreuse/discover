package com.ada.userfriend.data.entity;


import com.ada.data.entity.BaseEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_friend_request")
public class UserFriendRequest extends BaseEntity {

	public UserFriendRequest() {
		addDate = new Date();
		lastDate = new Date();
	}

	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private UserInfo user;

	/**
	 * 被请求用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "friendid")
	private UserInfo friend;

	/**
	 * 请求好友时间戳
	 */
	private Date addDate;

	/**
	 * 请求好友修改时间戳
	 */
	private Date lastDate;

	/**
	 * 申请附言
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

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

}
