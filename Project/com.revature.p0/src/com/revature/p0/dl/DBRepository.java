package com.revature.p0.dl;

import java.util.List;

import com.revature.p0.models.reimbursement;

public class DBRepository implements Irepository {
	private DAO<reimbursement,Integer> reimbursementDAO;
	
	public DBRepository(DAO<reimbursement,Integer> reimbursementDAO) {
		this.reimbursementDAO = reimbursementDAO;
	}
	@Override
	public void addreimbursement(reimbursement newreimbursement) {
		// TODO Auto-generated method stub
		reimbursementDAO.add(newreimbursement);
	}

	@Override
	public List<reimbursement> getReimbursement() {
		// TODO Auto-generated method stub
		return reimbursementDAO.findAll();
	}

	@Override
	public reimbursement getreimbursementById(int id){
		// TODO Auto-generated method stub
		return reimbursementDAO.findById(id);
	}

	@Override
	public void updateReimbursement(reimbursement updatedreimbursement) {
		// TODO Auto-generated method stub
		reimbursementDAO.update(updatedreimbursement);
	}

}
