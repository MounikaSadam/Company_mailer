package com.itgiga;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection getConnection(){
		Connection c=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/itgiga","root","");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return c;
	}
}
