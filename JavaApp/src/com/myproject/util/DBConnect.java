package com.myproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnected() {
		Connection c = null ;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/mgnrega" ;
		
		
		
		try {
			c = DriverManager.getConnection(url , "root" , "8080");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return c ; 
	}
}
