package com.abstractFactory.databaseFactory;

import com.abstractProduct.sqlConnection.DBConnection;
import com.abstractProduct.sqlConnection.ExecuteQuery;

public interface DatabaseFactory  {

	DBConnection createConnection();
	
	ExecuteQuery createQuery();
	
}
