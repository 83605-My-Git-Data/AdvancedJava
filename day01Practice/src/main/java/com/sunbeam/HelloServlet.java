package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hi")

public class HelloServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("HelloServlet.initss() is called");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("HelloServlet.destroy() is called");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Servlet.doGet() is called");
		
		 resp.setContentType("text/html");
		    PrintWriter out = resp.getWriter();
		   
		    
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Hello from aditya's hello servlet </title>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<h1>Hello from HelloW </h1>");
		    Date date = new Date();
		    out.println(date.toString());
		    out.println("</body>");
		   
		    
		   
		    out.println("</html");
	}
	

}
