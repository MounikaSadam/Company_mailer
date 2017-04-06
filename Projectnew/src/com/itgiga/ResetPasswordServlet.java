package com.itgiga;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
String mail=request.getParameter("email");
		
		
		PrintWriter out=response.getWriter();
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		
		
		out.println(mail);
		try{
			Connection con=DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select email from company_mail_user1 ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
		
		if(mail.equals(rs.getString("email"))){
			System.out.println("exist");
			
			request.getRequestDispatcher("ForgotPassword.jsp").include(request, response);
			out.println(password);
			
			
		}
//		else{
//			System.out.println("does not exist");
//		}
		}
//		out.println(password1);
//		if(password.equals(password1)){
//			
//		}
		//try{
			//Connection con=DbConnection.getConnection();
	//	PreparedStatement ps=con.prepareStatement("update company_mail_user1 set password=? where ");
//			ps.setString(1, password);
//			}
//	
//	catch(Exception e){
//		out.print(e);
//		}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	}