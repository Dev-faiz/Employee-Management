package com.myproject.util;

import java.sql.Connection;

public class DBMain {
	public static void main(String[] args) {
		
		Connection con = DBConnect.getConnected();
		
		
		if(con != null) {
			System.out.println("Connected");
		}else {
			System.out.println("There is some Error while connecting to sql ");
		}
	}
}
