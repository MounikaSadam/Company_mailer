package com.itgiga;

import java.sql.*;
public class ComposeDao {
	public static int save(int id,String sender,String receiver,String subject,String message){
		int status=0;
		try{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into company_mail_message(id,sender,receiver,subject,message,trash,messagedate) values(?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,sender);
			ps.setString(3,receiver);
			ps.setString(4,subject);
			ps.setString(5,message);
			ps.setString(6,"no");
			ps.setDate(7,Formatter.getCurrentDate());
			id++;
			
			status=ps.executeUpdate();System.out.println("6");
						
		}
		catch(Exception e){
			System.out.println(e);
		}
				
		return status;
	}
}
