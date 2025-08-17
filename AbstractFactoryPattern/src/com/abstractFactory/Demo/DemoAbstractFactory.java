package com.abstractFactory.Demo;

import com.factory.factoryServices.ClientConnectionServices;

public class DemoAbstractFactory {

	public static void main(String[] args) {
		ClientConnectionServices connection = new ClientConnectionServices();
		connection.sqlconnection("mysql");
		connection.sqlExecuteQuery();

	}

}
