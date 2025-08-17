package com.factory.communicationServices;

import java.time.LocalDateTime;

import com.factory.communicationImpl.CommunicationService;
import com.factory.modal.SMSModal;

public class SMSServices implements CommunicationService<SMSModal> {

	@Override
	public SMSModal sendMessage(String clientName, String message) {
		System.out.println(clientName+"Message: "+ message);
		return new SMSModal("SUCCESS", LocalDateTime.now(), "Notification: " + message.substring(0, Math.min(message.length(), 20)));
	}

}
