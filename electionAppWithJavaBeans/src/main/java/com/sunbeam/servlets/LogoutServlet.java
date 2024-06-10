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



//@WebServlet("/logout") 

public class LogoutServlet extends HttpServlet {
	
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
	
	protected void ProcessRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Logout</title>");
				out.println("</head>");
				out.println("<body>");
				
				String userName = "";
						Cookie[] arr = req.getCookies();
						if(arr != null) {
							for (Cookie c : arr) {
								if(c.getName().equals("uname")) {
									userName = c.getValue();
									break;
								}
							}
						}
						out.printf("Goodbye, %s<hr/>\n", userName);
						
						// delete persistent cookie
						Cookie c = new Cookie("uname", "");
						c.setMaxAge(-1);
						res.addCookie(c);
						
						HttpSession session = req.getSession();
								session.invalidate();
								
								
				out.println("Thank you for saving democracy. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
	}

}
