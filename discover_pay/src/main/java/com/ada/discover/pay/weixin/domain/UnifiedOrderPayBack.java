package com.ada.discover.pay.weixin.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class UnifiedOrderPayBack {

	private String return_code;
	private String err_code;

	
	private String return_msg;
	private String appid;
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String result_code;
	private String prepay_id;
	private String trade_type;
	public String getAppid() {
		return appid;
	}
	public String getErr_code() {
		return err_code;
	}
	public String getMch_id() {
		return mch_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public String getResult_code() {
		return result_code;
	}
	public String getReturn_code() {
		return return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public String getSign() {
		return sign;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	@Override
	public String toString() {
		return "PayBack [return_code=" + return_code + ", return_msg=" + return_msg + ", appid=" + appid + ", mch_id="
				+ mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign + ", result_code=" + result_code
				+ ", prepay_id=" + prepay_id + ", trade_type=" + trade_type + "]";
	}

}
