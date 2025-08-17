package com.abstractProduct.sqlConnectionImpl;

import com.abstractProduct.sqlConnection.DBConnection;

public class PGConnectionImpl implements DBConnection {

	@Override
	public void connect() {
		System.out.println("Connect to PG...");
		
	}

}
