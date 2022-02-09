package com.revature.p0.ui;

import java.util.Scanner;

import com.revature.p0.bl.Ireimbursementbl;
import com.revature.p0.models.reimbursement;

/**
 * @author vergi
 * ----------- class to present UI to end users to interact with program
 */
public class MainMenu {
	// declare it as a dependency
	private Scanner myscanner;
	private Ireimbursementbl reimbursementbl;
	
	// inject the dependency via constructor
	public MainMenu(Scanner myscanner, Ireimbursementbl reimbursementbl)
	{
		this.myscanner= myscanner;
		this.reimbursementbl = reimbursementbl;
	}
	public void start() {
		//method signature : access modified. non access modifier, return type*, methodName,(arguments), throws exceptions
		boolean keepGoing = true;
		do {
			System.out.println("What would you like to do?");
			System.out.println("[C] Create reimbursement request");
			System.out.println("[V] View reimbursement requests");
			System.out.println("[R] Review reimbursement requests");
			System.out.println("[E] Exit");
			
			String userInput = myscanner.nextLine().toUpperCase();
			switch (userInput) {
			case "C":
				System.out.println("Creating a reimbursement request");
				createreimbersement();
				break;
			case "V":
				System.out.println("Displaying reimbursement requests");
				getreimbursement();
				break;
			case "R":
				System.out.println("Enter a request that needs to be reviewed");
				break;
			case "E":
				System.out.println("Goodbye and have a great day!!!");
				keepGoing = false;
				break;
			default:
				System.out.println("Sorry wrong input, please try again");
				break;
			}
		} while (keepGoing);
	}
	private void getreimbursement() {
		// TODO Auto-generated method stub
		for(reimbursement reimbursement:reimbursementbl.getreimbursement()) {
			System.out.println(reimbursement);
		}
	}
	private void createreimbersement() {
		// TODO Auto-generated method stub
		System.out.println("Please enter your Full Name:- ");
		String name = myscanner.nextLine();
		System.out.println("Enter a type for your reimbursement request");
		System.out.println("[F] FOOD");
		System.out.println("[T] TRAVEL");
		System.out.println("[L] LODGING");
		System.out.println("[O] Other");
		//String type = myscanner.nextLine();
		String type = createtype();
		System.out.println("Enter a description for your reimbursment: ");
		String description = myscanner.nextLine();
		System.out.println("Enter the amount for your reimbursment");
		int amount = myscanner.nextInt();
		myscanner.nextLine();
		String status = myscanner.nextLine();
		reimbursement newreimbursement = new reimbursement(name, type , description, amount, status);
		// saving to storage
		reimbursementbl.addreimbursement(newreimbursement);
		System.out.println(newreimbursement);
	}
	
	private String createtype() {
		// TODO Auto-generated method stub
		String type = myscanner.nextLine().toUpperCase();
		switch (type) {
		case "F":
			System.out.println("FOOD");
			break;
		case "L":
			System.out.println("LODGING");
			break;
		case "T":
			System.out.println("TRAVEL");
			break;
		case "O":
			System.out.println("What is the other reason for your reimbursment request?");
			String other = myscanner.nextLine();
			System.out.println(other);
			break;
		default:
			System.out.println("Sorry wrong input, please try again");
			break;
	}
		return type;

	}
}