package com.abstractProduct.sqlConnectionImpl;

import com.abstractProduct.sqlConnection.ExecuteQuery;

public class PGExecuteQueryImpl implements ExecuteQuery {

	@Override
	public void executeQuery(String query) {
		System.out.println("Execute query for PG" + query);

	}

}
