package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;



//@WebServlet("/result")

public class ResultServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultProcessing(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultProcessing(req, resp);
		
	}
	
	protected void ResultProcessing(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		
		List<Candidate> list = new ArrayList<Candidate>();
		
		try {
			CandidateDao dao = new CandidateDaoImpl();
		list =	dao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				
				out.println("<html>");
		        out.println("<head>");
		        out.println("<title>All Candidate Information</title>");
		        out.println("<style>");
		        out.println("table { border-collapse: collapse; width: 100%; }");
		        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
		        out.println("th { background-color: #f2f2f2; }");
		        out.println("</style>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<h1>All Candidate Information</h1>");

		        out.println("<table>");
		        out.println("<tr>");
		        out.println("<th>ID</th>");
		        out.println("<th>Name</th>");
		        out.println("<th>Party</th>");
		        out.println("<th>Votes</th>");
		        out.println("<th>Action</th>");
		        out.println("</tr>");
		        
		        
		        for (Candidate candidate : list) {
		        	out.println("<tr>");
		        	out.println("<td>"+candidate.getId()+"</td>");
		        	out.println("<td>"+candidate.getName()+"</td>");
		        	out.println("<td>"+candidate.getParty()+"</td>");
		        	out.println("<td>"+candidate.getVotes()+"</td>");
		        	out.printf("<td><a href='delcand?id=%d'><img width='24' height='24' src='Images/delete.jpeg'/></a><a href='updcand?id=%d'><img width='24' height='24' src='Images/update.jpeg'/> </a> </td>\n",candidate.getId(),candidate.getId());
//		        	out.printf("<td><a href='updcand?id=%d'><img width='24' height='24' src='Images/update.jpeg'/> </a> </td>\n",candidate.getId());
//		        	
		        	out.println("</td>");

		    
				}
		        
		        out.println("</table>");
		        
		        String msg = (String) req.getAttribute("message");
		        		if(msg != null)
		        			out.println("<br/><br/>" + msg + "<br/><br/>");
		        		
		        		
		        out.println("<br/><a href='announcement.html'>Announcement</a>");

		        out.println("<a href='logout'>Sign Out</a>");
		        out.println("</body>");
		        out.println("</html>");
		        
		        
				
				
				
		
	}
	

}
