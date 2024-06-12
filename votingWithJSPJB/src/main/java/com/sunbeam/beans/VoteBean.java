package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	
	private int candidateId;
	private int voterID;
	int voted=0 ;
	
	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getVoterID() {
		return voterID;
	}

	public void setVoterID(int voterID) {
		this.voterID = voterID;
	}
	
	public int getVoted() {
		return voted;
	}

	public void setVoted(int voted) {
		this.voted = voted;
	}

	public void voteCandidate() {
		
		
		
		
		try {
			CandidateDao candidateDao = new CandidateDaoImpl();
			UserDao userDao = new UserDaoImpl();
			
			
			
			
				candidateDao.incrementVote(candidateId);
				voted =  userDao.updateStatus(voterID, true);
//				System.out.println("Voter id : "+voterID+"isVoted: "+voted);
				
				
				
			
			
			
		 
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	
	
	

}
