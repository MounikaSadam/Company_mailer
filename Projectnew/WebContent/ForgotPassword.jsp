<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String s = request.getParameter("email");
		//out.println(s);
	%>
	<form action="Reset" method="post">
		<table>
			<tr>
				<td>new password</td>
				<input type="text" name="email" value="<%=s%>" />
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>re enter Password:</td>
				<td><input type="password" name="password1" /></td>
			</tr>
			<tr>
				<td colspan="2"><input id="submit" type="submit" value="login" />


				</td>
			</tr>
		</table>
	</form>
	<%
		String password = request.getParameter("password");
		out.println(password);
	%>

</body>
</html>