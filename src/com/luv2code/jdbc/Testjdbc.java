package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		
		try{
			System.out.println("Connection to database: " + jdbcUrl);
			
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successfull");
					
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}

}
