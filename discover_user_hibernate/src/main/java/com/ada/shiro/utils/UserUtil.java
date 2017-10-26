package com.ada.shiro.utils;

import com.ada.shiro.realm.ShiroUser;
import com.ada.user.data.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class UserUtil {
	/**
	 * 获取当前用户对象shiro
	 * 
	 * @return shirouser
	 */
	public static ShiroUser getCurrentShiroUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	/**
	 * 获取当前用户session
	 * 
	 * @return session
	 */
	public static Session getSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户httpsession
	 * 
	 * @return httpsession
	 */
	public static Session getHttpSession() {
		Session session = SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户对象
	 * 
	 * @return user
	 */
	public static UserInfo getCurrentUser() {
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			return (UserInfo) session.getAttribute("user");
		} else {
			return null;
		}

	}

	public static UserInfo setCurrentUser(UserInfo user) {
		Session session = SecurityUtils.getSubject().getSession();
		if (null != session) {
			session.setAttribute("user", user);
			return (UserInfo) session.getAttribute("user");
		} else {
			return null;
		}
	}

}
