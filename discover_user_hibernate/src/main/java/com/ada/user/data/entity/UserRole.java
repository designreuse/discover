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
package com.ada.user.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.enums.RoleType;

/**
 * 用户角色
 */
@Entity
@Table(name = "user_role")
public class UserRole extends AbstractEntity {

	/**
	 * 别名
	 */
	private String alias;

	/** 权限 */
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "user_role_authority",joinColumns = { @JoinColumn(name = "role_id") })
	@Column(name = "permission", length = 100)
	private List<String> authorities = new ArrayList<String>();

	/**
	 * 角色描述
	 */
	@Column(length = 255)
	private String description;

	/**
	 * 角色类型，系统和自定义，系统角色不能删除
	 */
	@Column(name = "roleType")
	private RoleType type;

	/**
	 * 角色名
	 */
	@Basic(optional = false)
	@Column(length = 100)
	private String name;

	/**
	 * 角色分类 1后台角色 2为普通角色
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private UserRoleCatalog catalog;

	public UserRole() {
	}

	public UserRoleCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(UserRoleCatalog catalog) {
		this.catalog = catalog;
	}

	public UserRole(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public String getDescription() {
		return description;
	}


	public String getName() {
		return name;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public void setName(String name) {
		this.name = name;
	}

	public RoleType getType() {
		return type;
	}

	public void setType(RoleType type) {
		this.type = type;
	}
}
