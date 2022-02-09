package com.revature.p0.bl;

import java.util.List;

import com.revature.p0.models.reimbursement;

public interface Ireimbursementbl {

	void addreimbursement(reimbursement reimbursement);

	List<reimbursement> getreimbursement();

}