package com.abstractPattern.communicationImpl;

import java.time.LocalDateTime;

import com.abstractPattern.communication.Communication;
import com.abstractPattern.modal.SMSModal;

public class SMSAdapterServices implements Communication<SMSModal> {

	@Override
	public SMSModal sendMessage(String clientName, String message) {
		System.out.println(clientName + "Message: " + message);
		return new SMSModal("SUCCESS", LocalDateTime.now(),
				"Notification: " + message.substring(0, Math.min(message.length(), 20)));
	}

}