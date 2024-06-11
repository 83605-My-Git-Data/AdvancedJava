package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	
	private List<Candidate> candidateList ;
	
	public CandidateListBean() {
		this.candidateList = new ArrayList<Candidate>();
	
	}
	
	public List<Candidate> getCandidateList(){
		return candidateList;
	}
	
	public void setCandidateList(List<Candidate> list) {
		this.candidateList = candidateList;
		
	}
	
	public void fetchCandidates() {
		try(CandidateDao candidateDao = new CandidateDaoImpl()){
			candidateList = 	candidateDao.findAll();
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
