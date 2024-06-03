package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dto.Admin;
import com.dto.Student;

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Admin ad = (Admin) req.getSession().getAttribute("admin");
		if (ad != null) {
			StudentDao dao = new StudentDao();
			int id = Integer.parseInt(req.getParameter("id"));

			Student std = dao.findStudentById(id);

			dao.deleteStudentById(std);
			
			resp.getWriter().print("<h1>" + id + " is deleted...</h1>");
			req.getRequestDispatcher("dashboard.jsp").include(req, resp);
		} else {
			resp.getWriter().print("<h1> Login First...<h1>");
			req.getRequestDispatcher("AdminLogin.jsp").include(req, resp);
		}

	}

}
