package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;



//@WebServlet("/candlist")

public class CandidateListServlet extends HttpServlet {
	
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
		
		List<Candidate> list = new ArrayList<Candidate>();
		
		
		try {
			CandidateDao candidateDao = new CandidateDaoImpl();
			
			 list  = candidateDao.findAll();
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		res.setContentType("text/html");
			PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidates</title>");
				out.println("</head>");
				out.println("<body>");
//			out.println("<h3>Online Voting</h3>");
				
				ServletContext context = this.getServletContext();
				String namString  = context.getInitParameter("AppTitle");
				out.printf("<h3>%s</h3>",namString);
			
			
			String usernameString = "";
			Cookie[] arr = req.getCookies();
			
			if(arr != null) {
				for (Cookie cookie : arr) {
					if(cookie.getName().equals("uname"));{
						usernameString = cookie.getValue();
						break;
					}
					
				}
			}
			
			out.printf("Hello, %s<hr/>\n", usernameString);
			
			ServletContext ctx = this.getServletContext();
			String message = (String) ctx.getAttribute("announcement");
			System.out.println(message);
			
			if(message!= null) {
				out.printf("Announcement: %s <br/><br/>\n",message);
			}
			
			
			
			
			
				out.println("<form method='post' action='vote'>");
				for (Candidate c : list) {
					// <input type='radio' name='candidate' value='submit-value'/> display-label
					out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
							c.getId(), c.getName(), c.getParty());
				}
				out.println("<input type='submit' value='Vote'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
		
		
	}

}
