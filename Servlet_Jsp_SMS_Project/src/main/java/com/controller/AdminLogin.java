package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Admin;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		if(name.equals("Ahmed") && pass.equals("12345")) {
			Admin ad = new Admin(name, pass);
			
			req.getSession().setAttribute("admin", ad);
			resp.getWriter().print("<h1>Admin LogIn Successfull</h1>");
			req.getRequestDispatcher("SignUp.jsp").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>Invalid Credentials</h1>");
			req.getRequestDispatcher("AdminLogin.jsp").include(req, resp);
			
		}
	
	}

}
