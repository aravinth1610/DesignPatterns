package com.factory.communicationServices;

import java.time.LocalDateTime;

import com.factory.communicationImpl.CommunicationService;
import com.factory.modal.EmailModal;

public class EmailServices implements CommunicationService<EmailModal> {

	@Override
	public EmailModal sendMessage(String clientName, String message) {
		System.out.println(clientName+"Message: "+ message);
		return new EmailModal("SUCCESS", LocalDateTime.now(), "Notification: " + message.substring(0, Math.min(message.length(), 20)));
	}

}
