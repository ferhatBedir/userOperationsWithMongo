package com.ferhat.user.model;

public class LogModel {

	private String requestType;
	private Integer requestCount;
	private String RequestParam;


	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Integer getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}

	public String getRequestParam() {
		return RequestParam;
	}

	public void setRequestParam(String requestParam) {
		RequestParam = requestParam;
	}
}
