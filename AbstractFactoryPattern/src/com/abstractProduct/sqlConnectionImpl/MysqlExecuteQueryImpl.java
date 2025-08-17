package com.abstractProduct.sqlConnectionImpl;

import com.abstractProduct.sqlConnection.ExecuteQuery;

public class MysqlExecuteQueryImpl implements ExecuteQuery {

	@Override
	public void executeQuery(String query) {
		System.out.println("Execute query"+ query);
		
	}

}
