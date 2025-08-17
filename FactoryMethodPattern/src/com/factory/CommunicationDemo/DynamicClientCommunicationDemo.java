package com.factory.CommunicationDemo;

import com.factory.factoryServices.ClientCommunicationFactory;
/*
 * actory Method (In/Out prinicpal)
 
1) communication Services as Interface with has one method to Implement to all the Concreate class
2) Create a Concreate services class, Like -> EmailServices, SMSServices etc.
3) Create the Factory Services Class, In that create the Factory Method(return the communication Services Interface) to get based on preferred Services,  In that create the method to sendMessage 
4) In MAIN Class we can create the Object for FactoryServices Class and We can use the Factory method
 */
public class DynamicClientCommunicationDemo {

	public static void main(String[] args) {
		ClientCommunicationFactory factory = new ClientCommunicationFactory();
		factory.clientCommunicator("SNB", "Hi bay", "SMS");
	}

}
