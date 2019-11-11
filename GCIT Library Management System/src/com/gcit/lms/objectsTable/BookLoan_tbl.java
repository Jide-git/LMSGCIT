package com.gcit.lms.objectsTable;

public class BookLoan_tbl {
	
	private Integer bookId;
	private Integer branchId;
	private Integer CardNo;
	private String DateIn;
	private String dueDate;
	private String DateOut;
	
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
	 * @return the cardNo
	 */
	public Integer getCardNo() {
		return CardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		CardNo = cardNo;
	}
	/**
	 * @return the dateIn
	 */
	public String getDateIn() {
		return DateIn;
	}
	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}
	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * @return the dateOut
	 */
	public String getDateOut() {
		return DateOut;
	}
	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(String dateOut) {
		DateOut = dateOut;
	}
	
	

}
