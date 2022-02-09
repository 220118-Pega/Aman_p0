package com.revature.p0;


import com.revature.p0.controller.ReimbursementController;
import com.revature.p0.models.reimbursement;
import com.revature.p0.storage.reimbursementDAO;
import com.revature.p0.utils.DocumentationFactory;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;


public class RESTdriver {
	
public static void main(String[] args){
	reimbursementDAO refundDAO = new reimbursementDAO();
	Javalin app = Javalin.create(config -> {
		config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
	}).start(7000);
//	app.get("/", ctx ->{ctx.result("Hello World");});
// setup endpoint two things need - 1. path and 2. action, what's your code doing.
//method parameters -- string endPoint, Handler
	// get all issues on my website
	app.get("/reimbursement", OpenApiBuilder.documented(DocumentationFactory.getDoc("getReimbursement"), ctx -> {ctx.jsonStream(refundDAO.getAllreimbursement());}));
	// getting issue by id on website
	app.get("/reimbursement/{reimbursement_id}",OpenApiBuilder.documented(DocumentationFactory.getDoc("getReimbursementById"), ctx ->{
		String stringId = ctx.pathParam("reimbursement_id");
		int id = Integer.parseInt(stringId);
		reimbursement reimbursementbyId = refundDAO.getreimbursementbyId(id);
		ctx.jsonStream(reimbursementbyId);
	}));
	
	//add data through main
//	refundDAO.addreimbursement(new reimbursement("Amanpreet kaur", "Lodging", "Moving from apartments to House", 5000, "Approved"));
	
	//post data
//	app.post("/reimbursement", OpenApiBuilder.documented(DocumentationFactory.getDoc("getreimbursement"),ReimbursementController.add()));
	app.post("/reimbursement",OpenApiBuilder.documented(DocumentationFactory.getDoc("addReimbursement"), ctx -> {refundDAO.addreimbursement(ctx.bodyStreamAsClass(reimbursement.class));}));
	app.put("/reimbursement",OpenApiBuilder.documented(DocumentationFactory.getDoc("updateReimbursement"), ctx -> {refundDAO.updatereimbursement(ctx.bodyStreamAsClass(reimbursement.class));}));
//reimbursementDAO reimbursmentDao = new reimbursementDAO();
//for(reimbursement reimbursement:reimbursementDAO.getAllreimbursement())
//{
//System.out.println(reimbursement);		
//}

}

private static OpenApiOptions getOpenApiOptions() {
	// Application info
	//Configuring swagger
	Info applicationInfo = new Info().version("1.0").description("Reimbursement REST");
	return new OpenApiOptions(applicationInfo).path("/swagger-docs").swagger(new SwaggerOptions("/swagger").title("Reimbursement API Docs"));
}
}