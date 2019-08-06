package com.ferhat.user.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class LogModel {

	private String requestType;
	private Integer requestCount;
	private Date date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return super.toString();
	}


}
