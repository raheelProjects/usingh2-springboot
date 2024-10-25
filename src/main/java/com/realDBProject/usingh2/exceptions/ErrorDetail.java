package com.realDBProject.usingh2.exceptions;

import java.time.LocalDateTime;

public class ErrorDetail {

	
	private LocalDateTime timeStamp;
	private String message;
	private String Details;
	
	public ErrorDetail( String message, String details) {
		this.timeStamp = LocalDateTime.now();
		this.message = message;
		Details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}
	
	
	
}
