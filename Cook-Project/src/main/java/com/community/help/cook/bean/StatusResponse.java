package com.community.help.cook.bean;

/*
 * This class is used to tell the UI about the status of the request
 */
public class StatusResponse {

	private String statusCode;
	private String statusMsg;
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusMsg() {
		return statusMsg;
	}
	
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	
}
