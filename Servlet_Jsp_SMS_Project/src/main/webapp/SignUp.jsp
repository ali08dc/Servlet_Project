<%@page import="com.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
</head>
<body>

	<%
	Admin ad = (Admin) session.getAttribute("admin");

	if (ad != null) {
	%>

	<h1>SignUp</h1>
	<form action="signup">

		Name:<input type="text" name="name"><br>
		<br> Email:<input type="email" name="email"><br>
		<br> Password:<input type="password" name="pass"><br>
		<br> D.O.B:<input type="date" name="dob"><br>
		<br> Gender :<input type="radio" value="male" name="gender">Male
		<input type="radio" value="female" name="gender">Female <input
			type="radio" value="other" name="gender">Other <br>
		<br> Mobile No:<input type="tel" name="mob"><br>
		<br> Address:<input type="text" name="address"><br>
		<br> <input type="submit" value="SUBMIT"> <input
			type="reset" value="CANCEL">
	</form>
	<a href="dashboard.jsp"><button>GoToDashboard</button></a>


	<%
	} else {
	response.getWriter().print("<h1>LogIn First</h1>");
	request.getRequestDispatcher("AdminLogin.jsp");
	}
	%>



</body>
</html>