package com.factory.communicationImpl;

public interface CommunicationService<T> {

	public T sendMessage(String clientName, String message);

}
