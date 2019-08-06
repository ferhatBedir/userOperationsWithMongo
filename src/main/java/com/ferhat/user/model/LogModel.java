package com.ferhat.user.model;

import java.util.Date;

public class LogModel {

	private Integer requestCount = 0;
	private String requestType;

	public Integer getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		return super.toString();
	}


}
