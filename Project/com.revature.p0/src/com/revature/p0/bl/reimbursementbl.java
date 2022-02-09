package com.revature.p0.bl;

import java.util.List;

import com.revature.p0.dl.Irepository;
import com.revature.p0.models.reimbursement;

public class reimbursementbl implements Ireimbursementbl{
	private Irepository repo;
	public reimbursementbl(Irepository repo) {
		this.repo = repo;
	}
	@Override
	public void addreimbursement(reimbursement reimbursement) {
		// call my dl
		repo.addreimbursement(reimbursement);
	}
	@Override
	public List<reimbursement> getreimbursement(){
		return repo.getReimbursement();
	}
	
}
