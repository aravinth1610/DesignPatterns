package com.abstractPattern.abstractFactorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.abstractPattern.communication.Communication;
import com.abstractPattern.communicationImpl.EmailAdapterServices;
import com.abstractPattern.communicationImpl.SMSAdapterServices;

public class ClientCommunication {

	// We don't use supplier because it used  to create the instance not an object, 
	// We get class name with simpleClassName so we need an Object not an Instances
	
	private Map<String, Communication<?>> serviceFactories;

	// Spring will inject all beans that implement Communication<?> into the processors list.
	// You’re collecting them into a map like:
	private ClientCommunication(List<Communication<?>> processors) {
		serviceFactories = processors.stream()
				.collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
	}

	public ClientCommunication() {
		List<Communication<?>> processors = List.of(new EmailAdapterServices(), new SMSAdapterServices());
		serviceFactories = processors.stream()
				.collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
	}

	
	@SuppressWarnings("unchecked")
	private <T> Communication<T> createCommunication(String notificationService) {
		if (notificationService == null) {
			throw new IllegalArgumentException("Preferred channel cannot be null");
		}
		Communication<?> factory = serviceFactories.get(notificationService + "AdapterServices");

		if (factory == null) {
			throw new IllegalArgumentException("Unsupported communication channel: " + factory);
		}
		return (Communication<T>) factory;
	}

	public <T> T clientCommunicator(String clientName, String message, String notification) {
		Communication<T> service = createCommunication(notification);
		return service.sendMessage(clientName, message);
	}

}
