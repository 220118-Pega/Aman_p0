package com.revature.p0;

import java.util.Scanner;

import com.revature.p0.bl.reimbursementbl;
import com.revature.p0.dl.InMemoryrepo;
import com.revature.p0.ui.MainMenu;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// -----------------------------app starts here---------------------------------
		MainMenu menu = new MainMenu(new Scanner(System.in), new reimbursementbl(new InMemoryrepo()));
		menu.start();

	}

}
