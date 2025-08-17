package com.abstractPattern.communication;

public interface Communication<T> {

	public T sendMessage(String clientName, String message);

}
