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

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;



//@WebServlet("/vote")

public class VoteServlet extends HttpServlet {
	
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
		
//		String candidateId = req.getParameter("candidate");
//		int id  = Integer.parseInt(candidateId);
//		
//		
//		try {
//			CandidateDao candidateDao = new CandidateDaoImpl();
//			candidateDao.incrementVote(id);
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new ServletException(e);
//		}
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("curuser");
		
		int userId = user.getId();
		
		String messageString = "";
		
		if(user.getStatus() == 0) {
			
			//user have not voted
			
			String candidateId = req.getParameter("candidate");
			int id = Integer.parseInt(candidateId);
			
			
			try {
				CandidateDao candidateDao = new CandidateDaoImpl();
				
				candidateDao.incrementVote(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			messageString = "Your vote is registerd successfully. <br/><br/>";
						// mark user as voted in db
			
			
			try {
				UserDao userDao = new UserDaoImpl();
				userDao.updateStatus(userId, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			
			
			
		}
		
		else {
			//user already voted;
			
			messageString = "You have already voted. <br/><br/>";
		}
		
		
		
		res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Voted</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Online Voting</h3>");
						
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
						out.printf("Hello, %s<hr/>\n", userName);
				out.println(messageString);
				out.println("<a href='logout'>Sign Out</a>");
				out.println("</body>");
				out.println("</html>");
		
		
	}
	

}
