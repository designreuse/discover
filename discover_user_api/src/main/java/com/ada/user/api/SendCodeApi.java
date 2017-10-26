package com.ada.user.api;

public interface SendCodeApi {



	/**
	 * 发送验证码功能
	 * @param code 验证码
	 * @param product 产品
	 * @param signName 签名
	 * @param template 模板
	 * @param phone 手机
	 * @return
	 */
	public boolean sendCode(String code, String product, String signName, String template, String phone);

}
