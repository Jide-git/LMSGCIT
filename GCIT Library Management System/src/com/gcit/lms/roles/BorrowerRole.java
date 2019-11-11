package com.gcit.lms.roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.gcit.lms.DAOs.BookDAO;
import com.gcit.lms.DAOs.BookLoanDAO;
import com.gcit.lms.DAOs.BorrowerDAO;
import com.gcit.lms.DAOs.BranchDAO;
import com.gcit.lms.objectsTable.Author_tbl;
import com.gcit.lms.objectsTable.BookLoan_tbl;
import com.gcit.lms.objectsTable.Book_tbl;
import com.gcit.lms.objectsTable.Borrower_tbl;
import com.gcit.lms.objectsTable.Branch_tbl;

public class BorrowerRole {
	
	static connection connUtil = new connection();
	
	public static void checkOut() throws SQLException {

		
		Connection conn = null;
		try {
			int tmpCardNo = 0;
			conn = connUtil.getConnection();
			while(true) {
			BorrowerDAO borrower = new BorrowerDAO(conn);
			List<Borrower_tbl> borrowerLst = borrower.readAllBorrowers();
			System.out.println("Enter valid card number: ");
			Scanner sc = new Scanner(System.in);
			tmpCardNo = sc.nextInt();
			//Borrower_tbl borrowerObj = borrowerLst.get(cardNoEntry);
			int flag = 0;
			for(int i = 0; i < borrowerLst.size(); i++) {
				if(tmpCardNo == borrowerLst.get(i).getCardNo()) {
					flag = 1;
					break;
							
				}
			
			}
			
			if (flag == 1) {
				break;
			}
			
		}
			int cardNo = tmpCardNo;
			BranchDAO branchdao = new BranchDAO(conn);	
			List<Branch_tbl> branchLst = branchdao.readAllBranches();
			int index = 0;
			for (Branch_tbl b: branchLst) {
				System.out.println(index + 1 + ") " +b.getBranchName());
				index++;
			}
			System.out.println("Enter branch you want by index: ");
			Scanner sc1 = new Scanner(System.in);
			int branchPick = sc1.nextInt();
			
			Branch_tbl branchObj = branchLst.get(branchPick-1);
			BookDAO bdao = new BookDAO(conn);				
			List<Book_tbl> lstOfBooks = bdao.readAllBooksByBranch(branchObj);
			
			int bookIndex = 0;
			for (Book_tbl b: lstOfBooks) {
				
				System.out.println(bookIndex + 1 + ") " +b.getTitle());
				bookIndex++;
			}
			
			System.out.println("Enter book you want to checkout by index: ");
			Scanner scBook = new Scanner(System.in);
			int titlePick = scBook.nextInt();
			Book_tbl bookObj = lstOfBooks.get(titlePick-1);
			
			BookLoanDAO bookLoandao = new BookLoanDAO(conn);	
			BookLoan_tbl loanAcc = new BookLoan_tbl();
			loanAcc.setBookId(bookObj.getBookId());
			loanAcc.setBranchId(branchObj.getBranchId());
			loanAcc.setCardNo(cardNo);
			bookLoandao.saveBookLoan(loanAcc);
			
			System.out.println("000");
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return;
		
	
		
	}
	
	public void checkIn() throws SQLException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();        
		String dateIn = df.format(today);		
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			
			int tmpCardNo = 0;
			conn = connUtil.getConnection();
			while(true) {
			BorrowerDAO borrower = new BorrowerDAO(conn);
			List<Borrower_tbl> borrowerLst = borrower.readAllBorrowers();
			System.out.println("Enter valid card number: ");
			Scanner sc = new Scanner(System.in);
			tmpCardNo = sc.nextInt();
			//Borrower_tbl borrowerObj = borrowerLst.get(cardNoEntry);
			int flag = 0;
			for(int i = 0; i < borrowerLst.size(); i++) {
				if(tmpCardNo == borrowerLst.get(i).getCardNo()) {
					flag = 1;
					break;
							
				}
			
			}
			
			if (flag == 1) {
				break;
			}
			
		}
			int cardNo = tmpCardNo;
			
			BranchDAO branchdao = new BranchDAO(conn);	
			List<Branch_tbl> branchLst = branchdao.readAllBranches();
			int index = 0;
			for (Branch_tbl b: branchLst) {
				
				System.out.println(index + 1);
				System.out.println(b.getBranchName());
				index++;
			}
			System.out.println("Enter branch you want to check-In book by index: ");
			Scanner sc = new Scanner(System.in);
			int branchPick = sc.nextInt();
			
			Branch_tbl branchObj = branchLst.get(branchPick-1);
			BookDAO bdao = new BookDAO(conn);				
			List<Book_tbl> lstOfBooks = bdao.readAllBooksByBranch(branchObj);//perform a query instead that checks books in a branch by the bookId
			
			int bookIndex = 0;
			for (Book_tbl b: lstOfBooks) {
				System.out.println(bookIndex + 1);
				System.out.println(b.getTitle());
				bookIndex++;
			}
			
			System.out.println("Enter book you want to check-In by index: ");
			Scanner scBook = new Scanner(System.in);
			int titlePick = scBook.nextInt();
			Book_tbl bookObj = lstOfBooks.get(titlePick-2);
			
			BookLoanDAO bookLoandao = new BookLoanDAO(conn);	
			BookLoan_tbl loanAcc = new BookLoan_tbl();
			loanAcc.setBookId(bookObj.getBookId());
			loanAcc.setBranchId(branchObj.getBranchId());
			loanAcc.setDateIn(dateIn);
			loanAcc.setCardNo(cardNo);

			bookLoandao.saveBookLoan(loanAcc);
			
			//System.out.println("000");
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return;
		
	}
	

}
