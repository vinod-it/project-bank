package com.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String USERNAME= "root";
	public static final String PASSWORD= "0000";
	public static final String DATABASE_NAME= "JDBCtoServlet";
	public static final String HOST= "localhost";
	public static final String PORT= "3306";
	public static final String DRIVER= "com.mysql.cj.jdbc.Driver";
	public static final String DATABASE_TYPE= "mysql";
	public static final String CONNECTION_URL= "jdbc:%s://%s:%s/%s";
	private static Connection con = null;

	public static Connection 	initializeDatabase()
	        throws SQLException, ClassNotFoundException
	    {
			if(con==null) {
				Class.forName(DRIVER);
		        Connection con = DriverManager.getConnection(
		        		String.format(CONNECTION_URL, DATABASE_TYPE,HOST,PORT,DATABASE_NAME),
		                                                     USERNAME,
		                                                     PASSWORD);
		        return con;
			}else {
		    	return con;
		    }
	  }
	public static void closeConnection() throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
}




