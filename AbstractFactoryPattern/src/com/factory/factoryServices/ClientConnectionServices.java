package com.factory.factoryServices;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.abstractFactory.databaseFactory.DatabaseFactory;
import com.abstractFactory.databaseFactoryImpl.MysqlDatabaseFactoryImpl;
import com.abstractFactory.databaseFactoryImpl.PGDatabaseFactoryImpl;

public class ClientConnectionServices {

	private final Map<String, Supplier<DatabaseFactory>> serviceFactories = new HashMap<String, Supplier<DatabaseFactory>>();

	public ClientConnectionServices() {
		serviceFactories.put("mysql", MysqlDatabaseFactoryImpl::new);
		serviceFactories.put("pg", PGDatabaseFactoryImpl::new);
	}

	private DatabaseFactory createConnection(String connection) {
		if (connection == null) {
			throw new IllegalArgumentException("connection cannot be null");
		}
		Supplier<DatabaseFactory> factory = serviceFactories.get(connection.toLowerCase());

		if (factory == null) {
			throw new IllegalArgumentException("Unsupported communication channel: " + factory);
		}
		return factory.get();
	}

	DatabaseFactory connections;
	public void sqlconnection(String sql) {
		connections = createConnection(sql);;
		connections.createConnection().connect();
	}
	
	public void sqlExecuteQuery() {
		connections.createQuery().executeQuery("selecr * from user");
	}

}
