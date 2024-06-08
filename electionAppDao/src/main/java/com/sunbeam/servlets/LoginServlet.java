package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;


//@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			// TODO Auto-generated method stub
			ProcessRequest(req, resp);
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			ProcessRequest(req, resp);
		
		}
		
		
		protected void ProcessRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
			
			String email = req.getParameter("email");
			String password = req.getParameter("passwd");
			
			
			try {
				UserDao userDao = new UserDaoImpl();
				
				
				User user = userDao.findByEmail(email);
				
				if(user != null && user.getPassword().equals(password)) {
					//login is successful
					System.out.println("Login is successful: "+user);
					
					Cookie cookie = new Cookie("uname", user.getFirstName());
					cookie.setMaxAge(3600);
					
					res.addCookie(cookie);
					
					HttpSession session = req.getSession();
								session.setAttribute("curuser", user);
					
					if(user.getRole().equals("voter")) {
						res.sendRedirect("candlist");
					}
					else {
						res.sendRedirect("result");
					}
					
					
					
					
					
				}
				
				else {
					//login failed
					
					res.setContentType("text/html");
			 		 PrintWriter out  =  res.getWriter();
			 		 				out.println("<html>");
			 						out.println("<head>");
			 						out.println("<title>Login Failed</title>");
			 						out.println("</head>");
			 						out.println("<body>");
			 						out.println("Invalid email or password. <br/><br/>");
			 						out.println("<a href='index.html'>Login Again</a>");
			 						out.println("</body>");
			 						out.println("</html>");
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				throw new ServletException(e);
			}
			
		}
}
