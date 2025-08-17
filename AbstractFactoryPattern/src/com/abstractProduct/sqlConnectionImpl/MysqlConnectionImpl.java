package com.abstractProduct.sqlConnectionImpl;

import com.abstractProduct.sqlConnection.DBConnection;

public class MysqlConnectionImpl implements DBConnection{

	@Override
	public void connect() {
		System.out.println("Mysql Connections ...");
		
	}

}
