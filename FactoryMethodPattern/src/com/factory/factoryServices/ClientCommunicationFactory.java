package com.factory.factoryServices;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.factory.communicationImpl.CommunicationService;
import com.factory.communicationServices.EmailServices;
import com.factory.communicationServices.SMSServices;

//Factory class with map-based service creation
public class ClientCommunicationFactory {

	 private final Map<String, Supplier<CommunicationService<?>>> serviceFactories = new HashMap<String, Supplier<CommunicationService<?>>>();

	 // For Spring : not creating a new instance — I’m just returning the already injected Spring bean (emailService) inside a Supplier.
	 public ClientCommunicationFactory(EmailServices emailServices, SMSServices smsServices) {
		 serviceFactories.put("email", () -> emailServices);
		 serviceFactories.put("sms", () -> smsServices);
	 }

	 public ClientCommunicationFactory() {
		 serviceFactories.put("email", EmailServices::new);
		 serviceFactories.put("sms",  SMSServices::new);
	 }

	 
	// Factory method to create communication service based on preferred channel	 
	@SuppressWarnings("unchecked")
	private <T> CommunicationService<T> createCommunication(String notificationServices) {
		if (notificationServices == null) {
			throw new IllegalArgumentException("Preferred channel cannot be null");
		}
		Supplier<CommunicationService<?>> factory = serviceFactories.get(notificationServices.toLowerCase());

		if(factory == null) {
			throw new IllegalArgumentException("Unsupported communication channel: " + factory);
		}
		return (CommunicationService<T>) factory.get();
	}	 
	 
	
	public <T> T clientCommunicator(String clientName, String message, String notification){
	     CommunicationService<T> service = createCommunication(notification);
	     return service.sendMessage(clientName, message);	
	}
}
