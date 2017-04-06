package com.itgiga;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession s = request.getSession(true);
		String temp = (String)s.getAttribute("login");
		
		if (temp !=null && temp.equals("true")){
			response.sendRedirect("InboxServlet");
		}
		else {
			if(LoginDao.validate(email, password)){
			
			s.setAttribute("login", "true");
			s.setAttribute("email", email);
			out.println("1");
			response.sendRedirect("InboxServlet");
			
			}
			else{
			out.print("<p>Sorry, username or password error</p>");
			request.getRequestDispatcher("login.html").include(request, response);
			}
		
			request.getRequestDispatcher("footer.html").include(request, response);
		}
		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession(true);
		String temp = (String)s.getAttribute("login");
		if (temp !=null && temp.equals("true")){
			resp.sendRedirect("InboxServlet");
		} 
	}

}
