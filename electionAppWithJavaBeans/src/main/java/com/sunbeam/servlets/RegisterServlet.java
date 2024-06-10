package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;



//@WebServlet('/register')

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstNameString = req.getParameter("firstName");
		String lastNameString = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String dobStr = req.getParameter("dob");
		Date birth = Date.valueOf(dobStr);
		String roleString = req.getParameter("role");
		
		String role = "";
		
		
		if(roleString.equals("admin")) {
			role = "admin";
			
		}
		else {
			role = "voter";
		}
		
		
		User user = new User(firstNameString,lastNameString,email,password,birth,0,role);
		
		try {
			UserDao userDao = new UserDaoImpl();
			
			userDao.save(user);
			System.out.println("user added successfully");
			
			resp.sendRedirect("index.html");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
