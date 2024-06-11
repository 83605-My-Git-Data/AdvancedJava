package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.utils.Utils;



public class Dao implements AutoCloseable{
	protected Connection con;
	
	public Dao() throws SQLException {
		con = Utils.getConnection();
	}
	
	public void close() throws SQLException {
		try {
		if(con != null) {
			con.close();
		}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}

}
}
