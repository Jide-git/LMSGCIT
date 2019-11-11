package com.gcit.lms.Menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.gcit.lms.roles.BorrowerRole;
import com.gcit.lms.roles.Liberian;

public class Launcher {

	static BorrowerRole borrower = new BorrowerRole();
	static Liberian liberian = new Liberian();

	public void liberianService() throws SQLException {
		String[] options = { "Update the details of the library", "Add copies of Book to the Branch" };

		for (int i = 0; i < options.length; i++) {

			System.out.println(i + 1 + ") " + options[i]);

		}
		System.out.println("Select your desired action: ");
		Scanner sc1 = new Scanner(System.in);
		int liberianAction = sc1.nextInt()-1;

		if (options[liberianAction].equals(options[0]))

			liberian.libUpdate();
		else
			System.out.println("ffff");
	}

	public static void borrowerService() throws SQLException {
		String[] options = { "Check out book", "Check In book" };

		for (int i = 0; i < options.length; i++) {

			System.out.println(i + 1 + ") " + options[i]);

		}
		System.out.println("Select your desired action: ");
		Scanner sc1 = new Scanner(System.in);
		int borrowerAction = sc1.nextInt() + 1;

		if ("Check out book".equals(options[borrowerAction - 1]))

			borrower.checkOut();
		else
			borrower.checkIn();
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		String[] roles = { "Admin", "Liberian", "Borrower" };

		for (int i = 0; i < roles.length; i++) {

			System.out.println(i + 1 + ") " + roles[i]);

		}
		System.out.println("Select your role: ");
		Scanner sc = new Scanner(System.in);
		int usrRole = sc.nextInt() - 1;

		if (roles[usrRole].equals(roles[2])) {

			borrowerService();
			
		} else if (roles[usrRole].equals(roles[1])) {

			//liberianService();

		}

	}
}
