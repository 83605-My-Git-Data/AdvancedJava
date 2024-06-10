package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateServlet extends HttpServlet{
	
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
	
	protected void ResultProcessing(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
			String strid = req.getParameter("id");
			int id = Integer.parseInt(strid);
			
			try {
				CandidateDao candidateDao = new CandidateDaoImpl();
				int count =  candidateDao.deleteById(id);
				String msg = "Candidates deleted: " + count;
						req.setAttribute("message", msg);
			     RequestDispatcher rDispatcher =	req.getRequestDispatcher("result");
			     rDispatcher.forward(req, res);
				
				
				
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new ServletException(e);
			}
	}

}
