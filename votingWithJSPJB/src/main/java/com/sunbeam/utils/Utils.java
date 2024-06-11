package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	
	private static final String DB_STRING = "jdbc:mysql://localhost:3306/election";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Mysql@123";
	
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(DB_STRING,USERNAME,PASSWORD);
		return con;
		
		
	}

}
