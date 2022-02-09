package com.revature.p0.dl;

import java.util.List;

import com.revature.p0.models.reimbursement;

public interface Irepository {
	void addreimbursement(reimbursement newreimbursement);
	List<reimbursement> getReimbursement();
	reimbursement getreimbursementById(int id);
	void updateReimbursement(reimbursement updatedreimbursement);
}
