<%@page import="com.dto.Student"%>
<%@page import="com.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Admin ad = (Admin) session.getAttribute("admin");
	if(ad != null){
		
		Student s = (Student) session.getAttribute("std");
		
	%>
	
	<h1>Student Update Form</h1>
	<form action="studentupdate">
	Id:<input type="text" name="id" value="<%=s.getId() %>" readonly="readonly"><br><br>
	Name:<input type="text" name="name" value="<%=s.getName() %>">
	Email :<input type="email" name="email" value="<%=s.getEmail()%>"><br><br>
	Dob :<input type="date" name="dob" value="<%=s.getDob()%>"><br><br>
	Mob :<input type="tel" name="mob" value="<%=s.getMob()%>"><br><br>
	Address :<input type="text" name="address" value="<%=s.getAddress()%>"><br><br>
		<input type="submit" value="UPDATE">
		<input type="reset" value="CANCEL">	
	</form><br>
	
	<%	
	}else{
		response.getWriter().print("<h1> Login First...<h1>");
		request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
		
	}
	%>
	<a href="logout"><button>LogOut</button></a>

</body>
</html>