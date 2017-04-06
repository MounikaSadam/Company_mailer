package com.itgiga;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
@WebServlet("/TrashServlet")
public class TrashServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
			String email=(String)session.getAttribute("email");
			out.print("<span style='float:right'>Hi, "+email+"</span>");
			out.print("<h1>Trash</h1>");
			
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				out.print("<p>"+msg+"</p>");
			}
			
			try{
				Connection con=DbConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from company_mail_message where receiver=? OR sender=? and trash=? order by id desc");
				ps.setString(1,email);
				ps.setString(2,email);
				ps.setString(3,"yes");
				
				ResultSet rs=ps.executeQuery();
				out.print("<table border='1' style='width:700px;'>");
				out.print("<tr style='background-color:grey;color:white'><td>Sender</td><td>Subject</td><td>Delete</td></tr>");
				while(rs.next()){
					out.print("<tr><td>"+rs.getString("sender")+"</td><td><p><a href='ViewMailServlet?id="+rs.getString("id")+"'>"+rs.getString("subject")+"</a></p></td><td><p><a href='PermanentDeleteMailServlet?id="+rs.getString(1)+"'>Delete Mail</a></p></td></tr>");
					//out.print("<p><a href='DeleteMailServlet?id="+rs.getString(1)+"'>Delete Mail</a></p>");			
					
				}
				out.print("</table>");
				
				con.close();
			}catch(Exception e){out.print(e);}
		}
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();

	}

}
