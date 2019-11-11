package com.gcit.lms.roles;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.gcit.lms.DAOs.BookDAO;
import com.gcit.lms.DAOs.BookLoanDAO;
import com.gcit.lms.DAOs.BranchDAO;
import com.gcit.lms.DAOs.NoOfCopiesDAO;
import com.gcit.lms.DAOs.BorrowerDAO;
import com.gcit.lms.DAOs.BranchDAO;
import com.gcit.lms.objectsTable.BookLoan_tbl;
import com.gcit.lms.objectsTable.Book_tbl;
import com.gcit.lms.objectsTable.Borrower_tbl;
import com.gcit.lms.objectsTable.Branch_tbl;
import com.gcit.lms.objectsTable.NoOfCopies;

public class Liberian {

	static connection connUtil = new connection();

	public static void libUpdate() throws SQLException {
		
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BranchDAO branchdao = new BranchDAO(conn);	
			List<Branch_tbl> branchLst = branchdao.readAllBranches();
			int index = 0;
			for (Branch_tbl b: branchLst) {
				
				System.out.println(index + 1);
				System.out.println(b.getBranchName());
				index++;
			}
			System.out.println("Enter branch you want to update by index: ");
			Scanner sc1 = new Scanner(System.in);
			int branchPick = Integer.parseInt(sc1.nextLine()); 
;
			
			Branch_tbl branchObj = branchLst.get(branchPick-1);
			BranchDAO branchDAO = new BranchDAO(conn);	
//			Branch_tbl upBranch = new Branch_tbl();
			
			System.out.println("Enter branch name: ");
			Scanner sc2 = new Scanner(System.in);
			String branchName = sc2.nextLine();
			branchObj.setBranchName(branchName);
			//System.out.println(upBranch.getBranchName());

			
			System.out.println("Enter address: ");
			Scanner sc3 = new Scanner(System.in);
			String branchAddress = sc2.nextLine();
			branchObj.setBranchAdress(branchAddress);
			
//			upBranch.setBranchId(branchObj.getBranchId());
			branchDAO.updateBranch(branchObj);
			
			//System.out.println(upBranch.getBranchId());

			conn.commit();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} 
		finally{
			conn.close();
		}
		return;
	}
		
		public static void addBookCopies() throws SQLException {
				
			Connection conn = null;
			try {
				conn = connUtil.getConnection();
				
				
				conn = connUtil.getConnection();
				
				BranchDAO branchdao = new BranchDAO(conn);	
				List<Branch_tbl> branchLst = branchdao.readAllBranches();
				int index = 0;
				for (Branch_tbl b: branchLst) {
					
					System.out.println(index + 1);
					System.out.println(index + 1 + ") "+ b.getBranchName());
					index++;
				}
				System.out.println("Enter branch you want to add book copies to by index: ");
				Scanner sc = new Scanner(System.in);
				int branchPick = sc.nextInt();
				
				Branch_tbl branchObj = branchLst.get(branchPick-1);
				BookDAO bdao = new BookDAO(conn);				
				List<Book_tbl> lstOfBooks = bdao.readAllBooksByBranch(branchObj);
				
				int bookIndex = 0;
				for (Book_tbl b: lstOfBooks) {
					System.out.println(bookIndex + 1);
					System.out.println(bookIndex + 1 + ") " +b.getTitle());
					bookIndex++;
				}
				
				System.out.println("Enter book you want to add copies to: ");
				Scanner scBook = new Scanner(System.in);
				int titlePick = Integer.parseInt(scBook.nextLine());
				
				System.out.println("Enter number of copies to add: ");
				Scanner scCopies = new Scanner(System.in);
				int Copies = Integer.parseInt(scBook.nextLine());
		
				Book_tbl bookObj = lstOfBooks.get(titlePick);				
				NoOfCopiesDAO bookCopiesDAO = new NoOfCopiesDAO(conn);	
				NoOfCopies bookCopies = new NoOfCopies();
				bookCopies.setBookId(bookObj.getBookId());
				bookCopies.setTotalBookCopies(bookObj.getCopies()+ Copies);
				bookCopiesDAO.updatesBookCopies(bookCopies);
				
				System.out.println(bookObj.getCopies()+ Copies);
				

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} finally{
				conn.close();
			}
			return;
			
		}
	
		
	}


