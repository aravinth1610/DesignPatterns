package com.factory.modal;

import java.time.LocalDateTime;

public class SMSModal {

	private final String status;
	private final LocalDateTime timestamp;
	private final String emailSubject;

	public String getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public SMSModal(String status, LocalDateTime timestamp, String emailSubject) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.emailSubject = emailSubject;
	}

}
