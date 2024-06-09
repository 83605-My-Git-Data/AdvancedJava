package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;


//@WebServlet("upcand")

public class UpdateCandidateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProcessRequest(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = req.getParameter("id");
		int id = Integer.parseInt(idString);
		String nameString = req.getParameter("name");
		String partyString = req.getParameter("party");
		String voteString = req.getParameter("votes");
		int votes = Integer.parseInt(voteString);
		
		
		Candidate candidate = new Candidate(id, nameString, partyString, votes);
		try {
			CandidateDao candidateDao = new CandidateDaoImpl();
			 int count = candidateDao.update(candidate);
			System.out.println("Updated the candidate");
			String msg = "Candidates Edited: " + count;
					req.setAttribute("message", msg);
						
						RequestDispatcher rd = req.getRequestDispatcher("result");
						rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void ProcessRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		String idString = req.getParameter("id");
		
		int id = Integer.parseInt(idString);
		
		Candidate candidate = null;
		
		
		try {
			CandidateDao candidateDao = new CandidateDaoImpl();
			  candidate =  candidateDao.findById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Edit Candidate</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Online Voting</h3>");
				out.println("<form method='post' action='editcand'>");
				out.printf("<input type='hidden' name='id' value='%d' readonly/><br/><br/>\n", candidate.getId());
				out.printf("Name: <input type='text' name='name' value='%s'/><br/><br/>\n", candidate.getName());
				out.printf("Party: <input type='text' name='party' value='%s'/><br/><br/>\n", candidate.getParty());
				out.printf("Votes: <input type='text' name='votes' value='%d' readonly/><br/><br/>\n", candidate.getVotes());
				out.println("<input type='submit' value='Update Candidate'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
		
		
	
		
	}

}
