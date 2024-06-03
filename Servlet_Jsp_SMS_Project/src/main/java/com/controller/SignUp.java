package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dto.Admin;
import com.dto.Student;

@WebServlet("/signup")
public class SignUp extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Admin ad = (Admin) req.getSession().getAttribute("admin");
		if(ad != null) {
			
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			Date dob = Date.valueOf(req.getParameter("dob"));
			String gernder = req.getParameter("gender");
			long mob = Long.parseLong(req.getParameter("mob"));
			String address = req.getParameter("address");
			
			
			Student std = new Student();
			
			std.setName(name);
			std.setEmail(email);
			std.setPassword(pass);
			std.setGender(gernder);
			std.setMob(mob);
			std.setDob(dob);
			std.setAddress(address);
			
			StudentDao dao = new StudentDao();
			dao.saveStudent(std);
			
			resp.getWriter().print("<h1>Student Data Saved</h1>");
			req.getRequestDispatcher("dashboard.jsp").include(req, resp);
			
			
		}
		else {
			resp.getWriter().print("<h1>LogIn First...</h1>");
			req.getRequestDispatcher("AdminLogin.jsp").include(req, resp);
		}
	}

}
