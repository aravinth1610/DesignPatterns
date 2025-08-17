package com.abstractFactory.databaseFactoryImpl;

import com.abstractFactory.databaseFactory.DatabaseFactory;
import com.abstractProduct.sqlConnection.DBConnection;
import com.abstractProduct.sqlConnection.ExecuteQuery;
import com.abstractProduct.sqlConnectionImpl.PGConnectionImpl;
import com.abstractProduct.sqlConnectionImpl.PGExecuteQueryImpl;

public class PGDatabaseFactoryImpl implements DatabaseFactory {

	@Override
	public DBConnection createConnection() {
		return new PGConnectionImpl();
	}

	@Override
	public ExecuteQuery createQuery() {
		return new PGExecuteQueryImpl();
	}

}

