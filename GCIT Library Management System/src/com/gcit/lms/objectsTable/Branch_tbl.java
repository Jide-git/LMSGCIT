package com.gcit.lms.objectsTable;

import java.util.List;

public class Branch_tbl {
	
	private Integer branchId;
	private String 	branchName;
	private String 	branchAdress;
	private List<BookLoan_tbl> bookLoans;
	private List<NoOfCopies> bookCopies;
	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the branchAdress
	 */
	public String getBranchAdress() {
		return branchAdress;
	}
	/**
	 * @param branchAdress the branchAdress to set
	 */
	public void setBranchAdress(String branchAdress) {
		this.branchAdress = branchAdress;
	}
	/**
	 * @return the bookLoans
	 */
	public List<BookLoan_tbl> getBookLoans() {
		return bookLoans;
	}
	/**
	 * @param bookLoans the bookLoans to set
	 */
	public void setBookLoans(List<BookLoan_tbl> bookLoans) {
		this.bookLoans = bookLoans;
	}
	/**
	 * @return the bookCopies
	 */
	public List<NoOfCopies> getBookCopies() {
		return bookCopies;
	}
	/**
	 * @param bookCopies the bookCopies to set
	 */
	public void setBookCopies(List<NoOfCopies> bookCopies) {
		this.bookCopies = bookCopies;
	}



}
