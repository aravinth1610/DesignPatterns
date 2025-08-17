package com.abstractPattern.modal;

import java.time.LocalDateTime;

public class EmailModal {

	private final String status;
	private final LocalDateTime timestamp;
	private final String emailSubject;

	public EmailModal(String status, LocalDateTime timestamp, String emailSubject) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.emailSubject = emailSubject;
	}

	public String getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

}
