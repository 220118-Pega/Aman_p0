package com.revature.p0.controller;

import com.revature.p0.bl.Ireimbursementbl;
import com.revature.p0.models.reimbursement;

import io.javalin.http.Handler;

public class ReimbursementController implements Icontroller {
	
	private static Ireimbursementbl reimbursementbl;
	
	public ReimbursementController(Ireimbursementbl reimbursementbl) {
		this.reimbursementbl = reimbursementbl;
	}

//	-------------------------------------------- handler is a functional interface. a means to pass functions as parameters. return lambda function?
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return ctx -> {
			// marshalling my list of issues to json format
			ctx.jsonStream(reimbursementbl.getreimbursement());
		};
	}

	@Override
	public Handler getbyId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			//unmarshall my reimbursement into an issue class
			//bodyasclass method unmarshalls the request body into the structure of the class you input into it
			//transforms the request body as the specified class
			reimbursement newreimbursement = ctx.bodyStreamAsClass(reimbursement.class);
			try {
				reimbursementbl.addreimbursement(newreimbursement);
				ctx.status(201);
			}catch (Exception e) {
				ctx.status(400);
			}
			
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
