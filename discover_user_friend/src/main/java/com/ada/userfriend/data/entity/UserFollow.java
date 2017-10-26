/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.ada.userfriend.data.entity;

import com.ada.data.entity.BaseEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_follow")
public class UserFollow extends BaseEntity {

	public UserFollow(){
		addDate=new Date();
		lastDate=new Date();
	}
	
	/**
	 * 用户
	 */
	@JoinColumn(name="userid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;
	
	
	/**
	 * 用户
	 */
	@JoinColumn(name="followid")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo follower;
	
	private Date addDate;
	
	private Date lastDate;



	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public UserInfo getFollower() {
		return follower;
	}

	public void setFollower(UserInfo follower) {
		this.follower = follower;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

}
