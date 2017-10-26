package com.ada.plug.data.vo;

import java.io.Serializable;

public class PushBack implements Serializable {

	private String msgId;
	private Long sendTime;
	private String timerId;
	private String requestId;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public String getTimerId() {
		return timerId;
	}

	public void setTimerId(String timerId) {
		this.timerId = timerId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "PushBack [msgId=" + msgId + ", sendTime=" + sendTime + ", timerId=" + timerId + ", requestId="
				+ requestId + "]";
	}

}
