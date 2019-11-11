package com.gcit.lms.objectsTable;

public class NoOfCopies {
	private Integer totalBookCopies;
	private Branch_tbl branchId;
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	private Integer bookId;

	/**
	 * @return the branchId
	 */
	public Branch_tbl getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Branch_tbl branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the totalBookCopies
	 */
	public Integer getTotalBookCopies() {
		return totalBookCopies;
	}

	/**
	 * @param totalBookCopies the totalBookCopies to set
	 */
	public void setTotalBookCopies(Integer totalBookCopies) {
		this.totalBookCopies = totalBookCopies;
	}

}
