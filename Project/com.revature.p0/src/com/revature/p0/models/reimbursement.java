package com.revature.p0.models;

import java.util.List;

/**
 * 
 * 
 * @author vergi
 *
 */
public class reimbursement {
	// class is the blueprint
// fields -- used to define dependencies of the class, characteristics of a class
	private String name;
	private String type;
	private String description;
	private int amount; 
	private int id;
	private String status;
	
	
// constructors -- special methods to initialize properties of a class
	// no args constructor
	public reimbursement() {
		
		
	}
	
	
	public reimbursement(String name, String type, String description, int amount, String status) {
	super();
	this.name = name;
	this.type = type;
	this.description = description;
	this.amount = amount;
	this.status = status;
}


	// parameterized constructors
	public reimbursement(String name, String type, String description, int amount, String status, int id) {
		// this keyword pertains to the particular instance 
		// basically it tells that whatever type input is = title
		this.name = name;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.id =id;

	}
	
	// calling constructor within a constructor is called constructor chaining as shown in example below, and it should be the first statement
//	public reimbursement(String name, String type, String description, int amount, String status, int id) {
//		this(name,type,description, amount, status); //example
//		this.id = id;
//	}
	//methods -- 


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	// format of object when converted to string


	@Override
	public String toString() {
		return "reimbursement [name=" + name + ", type=" + type + ", description=" + description + ", amount=" + amount
				+ ", id=" + id + ", status=" + status + "]";
	}



}
	
