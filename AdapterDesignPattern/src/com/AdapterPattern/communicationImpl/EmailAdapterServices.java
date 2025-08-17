package com.abstractPattern.communicationImpl;

import java.time.LocalDateTime;

import com.abstractPattern.communication.Communication;
import com.abstractPattern.modal.EmailModal;

public class EmailAdapterServices implements Communication<EmailModal> {

	@Override
	public EmailModal sendMessage(String clientName, String message) {
		System.out.println(clientName+"Message: "+ message);
		return new EmailModal("SUCCESS", LocalDateTime.now(), "Notification: " + message.substring(0, Math.min(message.length(), 20)));
	}

}
