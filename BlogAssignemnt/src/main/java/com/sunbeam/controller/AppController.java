package com.sunbeam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		processReq(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processReq(req, resp);

	}
	
	
	protected void processReq(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		
		String page = req.getParameter("page");
		String uri = "/WEB-INF/views/index.jsp";
		
		if(page.equals("index")){
			uri = "/WEB-INF/views/index.jsp";
			
		}
		else if(page.equals("login")) {
			uri = "/WEB-INF/views/login.jsp";
		}
		else if(page.equals("newuser")) {
			uri = "/WEB-INF/views/newuser.jsp";
		}
		else if(page.equals("register")) {
			uri = "/WEB-INF/views/register.jsp";
		}
		
		
		ServletContext context = this.getServletContext();
		
		RequestDispatcher rd = context.getRequestDispatcher(uri);
		rd.forward(req, res);
		
	
		
	}
	

}
