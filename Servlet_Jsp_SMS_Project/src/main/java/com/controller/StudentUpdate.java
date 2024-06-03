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

@WebServlet("/studentupdate")
public class StudentUpdate extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Admin a=(Admin) req.getSession().getAttribute("admin");
		if(a!=null)
		{
		
		//fetch
				String id =req.getParameter("id");
				int id1=Integer.parseInt(id);
				
				String name =req.getParameter("name");
				String email = req.getParameter("email");
				Date dob =Date.valueOf(req.getParameter("dob"));
				long mobileNumber=Long.parseLong(req.getParameter("mob"));
				String address  = req.getParameter("address");
				
				StudentDao dao = new StudentDao();
				Student s = dao.findStudentById(id1);//find
				s.setName(name);
				s.setEmail(email);
				s.setDob(dob);
				s.setMob(mobileNumber);
				s.setAddress(address);
				
				dao.updateStudent(s);//update
				
				resp.getWriter().print("<h1>"+ id1 +" is updated...</h1>");
		        req.getRequestDispatcher("dashboard.jsp").include(req, resp);
		        
		}
		else
		{
			 resp.getWriter().print("<h1> Login First...<h1>");
      	     req.getRequestDispatcher("AdminLogin.jsp").include(req, resp);
		}
		
	}

}
