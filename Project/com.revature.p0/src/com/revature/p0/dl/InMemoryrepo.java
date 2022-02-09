package com.revature.p0.dl;

import java.util.ArrayList;
import java.util.List;

import com.revature.p0.models.reimbursement;

/** 
 * ------------------------------------------------repository that connects to an inmemory storage-----------------
 * @author vergi
 *
 */
public class InMemoryrepo implements Irepository {
	private static ArrayList<reimbursement> listofreimbursement;
	private static int LatestId;
	
	public InMemoryrepo() {
		// seeding my list of issues with fake data
		listofreimbursement = new ArrayList<reimbursement>(){{
			add (new reimbursement("BL and DL", "No idea what i am doing", "Help required",1,"Pending", 1));
			add (new reimbursement("Java", "Little bit idea what i am doing","lets goooo",1,"Approved", 2));
		}};
	
		LatestId = 3;
	}
	
	
	@Override
	public void addreimbursement(reimbursement newreimbursement) {
		// TODO Auto-generated method stub
		newreimbursement.setId(LatestId);
		listofreimbursement.add(newreimbursement);
		LatestId++;
	}


	@Override
	public List<reimbursement> getReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public reimbursement getreimbursementById(int id){
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateReimbursement(reimbursement updatedreimbursement) {
		// TODO Auto-generated method stub
		
	}

}
