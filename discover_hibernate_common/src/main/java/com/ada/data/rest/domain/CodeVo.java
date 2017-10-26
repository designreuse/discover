package com.ada.data.rest.domain;

/**
 * 
 * 
 * 验证码返回对象 <br/>
 * 1为该手机号被注册过了 <br/>
 * 0为可以使用 <br/>
 * 
 * @author ada
 *
 */
public class CodeVo extends AbstractVo {

	/**
	 * 验证码
	 */
	private String vcode;

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Override
	public String toString() {
		return "CodeVo [vcode=" + vcode + ", toString()=" + super.toString() + "]";
	}
	

}
