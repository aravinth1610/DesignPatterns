package com.abstractPattern.Demo;

import com.abstractPattern.abstractFactorService.ClientCommunication;

public class Demo {

	public static void main(String[] args) {
		ClientCommunication factory = new ClientCommunication();
		factory.clientCommunicator("SNB", "Hi bay", "SMS");

	}

}
