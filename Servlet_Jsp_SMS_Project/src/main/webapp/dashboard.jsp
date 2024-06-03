<%@page import="com.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDao"%>
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

	if (ad != null) {

		StudentDao dao = new StudentDao();
		List<Student> studentList = dao.findAll();
	%>
	<h1>DASHBOARD</h1>
	<table border="1px solid black" cellpadding="5px" cellspacing="5px" width="100%">
		<tr> 
		<th>SN</th>
		<th>Stu_ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Gender</th>
		<th>D.O.B</th>
		<th>Mobile</th>
		<th>Address</th>
		<th>Update</th>
		<th>Delete</th>
		
		</tr>
		
		<%
		int sl = 1;
		for(Student std:studentList){	
		%>
		
		<tr>
		<td><%=sl++ %></td>
		<td><%=std.getId() %></td>
		<td><%=std.getName() %></td>
		<td><%=std.getEmail() %></td>
		<td><%=std.getGender() %></td>
		<td><%=std.getDob() %></td>
		<td><%=std.getMob() %></td>
		<td><%=std.getAddress() %></td>
		<td><a href="update?id=<%=std.getId() %>"><button>Edit</button></a></td>
		<td><a href="delete?id=<%=std.getId() %>"><button>Delete</button></a></td>
		
		</tr>
			
		<%	
		}
		%>

	</table><br>

	<%
	}else{
		response.getWriter().print("<h1>LogIn First...</h1>");
		request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
	}
	%>
	
	<a href="logout"> <button>LogOut</button></a>

</body>
</html>