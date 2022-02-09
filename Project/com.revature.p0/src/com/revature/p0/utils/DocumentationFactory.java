package com.revature.p0.utils;

import com.revature.p0.models.reimbursement;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;

/**
 * return documentation for my endpoints
 * @author vergi
 *
 */
public class DocumentationFactory {
	public static OpenApiDocumentation getDoc(String endPoint)
	{
		switch (endPoint)
		{
		case "getReimbursement":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("reimbursement");
			}).jsonArray("200", reimbursement.class);
		case "getReimbursementById":
			return OpenApiBuilder.document().operation(op ->{
				op.addTagsItem("reimbursement");
			}).json("200", reimbursement.class);
		case "addReimbursement":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("reimbursement");
			}).body(reimbursement.class).result("201");
		case "updateReimbursement":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("reimbursement");
			}).body(reimbursement.class).result("201");
		default:
			return null;
		}
	}

}
