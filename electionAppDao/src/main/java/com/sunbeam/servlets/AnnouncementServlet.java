package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/announce")

public class AnnouncementServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessResult(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessResult(req, resp);
	}
	
	protected void ProcessResult(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String message = req.getParameter("announcement");
		System.out.println("the message is: "+message);
		
		ServletContext context = this.getServletContext();
		context.setAttribute("announcement", message);
		res.sendRedirect("result");
	}

}
