/*
 * 
 * 
 * 
 */
package com.ada.plug.data.entity;

import com.ada.data.entity.AbstractEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity - 收款单
 * 
 * 
 * 
 */
//@Entity
//@Table(name = "plugin_payment_system")
public class SystemPayment extends AbstractEntity {

	private static final long serialVersionUID = -5052430116564638634L;

	/** 支付方式分隔符 */
	public static final String PAYMENT_METHOD_SEPARATOR = " - ";

	/**
	 * 类型
	 */
	public enum Type {

		/** 订单支付 */
		payment,

		/** 预存款充值 */
		recharge
	}

	/**
	 * 方式
	 */
	public enum Method {

		/** 在线支付 */
		online,

		/** 线下支付 */
		offline,

		/** 预存款支付 */
		deposit
	}

	/**
	 * 状态
	 */
	public enum Status {

		/** 等待支付 */
		wait,

		/** 支付成功 */
		success,

		/** 支付失败 */
		failure
	}

	/** 编号 */
	private String sn;

	/** 类型 */
	private Type type;

	/** 方式 */
	private Method method;

	/** 状态 */
	private Status status;

	/** 支付方式 */
	private String paymentMethod;

	/** 收款银行 */
	private String bank;

	/** 收款账号 */
	private String account;

	/** 支付手续费 */
	private BigDecimal fee;

	/** 付款金额 */
	private BigDecimal amount;

	/** 付款人 */
	private String payer;

	/** 操作员 */
	private String operator;

	/** 付款日期 */
	private Date paymentDate;

	/** 备注 */
	private String memo;

	/** 支付插件ID */
	private String paymentPluginId;

	/** 到期时间 */
	private Date expire;




	public String getSn() {
		return sn;
	}


	public void setSn(String sn) {
		this.sn = sn;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public BigDecimal getFee() {
		return fee;
	}


	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getPayer() {
		return payer;
	}


	public void setPayer(String payer) {
		this.payer = payer;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public String getPaymentPluginId() {
		return paymentPluginId;
	}


	public void setPaymentPluginId(String paymentPluginId) {
		this.paymentPluginId = paymentPluginId;
	}


	public Date getExpire() {
		return expire;
	}


	public void setExpire(Date expire) {
		this.expire = expire;
	}


	




}