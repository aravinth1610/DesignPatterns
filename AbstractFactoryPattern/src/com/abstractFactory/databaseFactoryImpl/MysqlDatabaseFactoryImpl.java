package com.abstractFactory.databaseFactoryImpl;

import com.abstractFactory.databaseFactory.DatabaseFactory;
import com.abstractProduct.sqlConnection.DBConnection;
import com.abstractProduct.sqlConnection.ExecuteQuery;
import com.abstractProduct.sqlConnectionImpl.MysqlConnectionImpl;
import com.abstractProduct.sqlConnectionImpl.MysqlExecuteQueryImpl;

public class MysqlDatabaseFactoryImpl implements DatabaseFactory {

	@Override
	public DBConnection createConnection() {
		return new MysqlConnectionImpl();
	}

	@Override
	public ExecuteQuery createQuery() {
		return new MysqlExecuteQueryImpl();
	}

}
