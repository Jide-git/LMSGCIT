package com.gcit.lms.objectsTable;

import java.util.List;

public class Borrower_tbl {

	private Integer cardNo;
	private String 	name;
	private List<Book_tbl> bookLoans;
	private String address;
	/**
	 * @return the cardNo
	 */
	public Integer getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bookLoans
	 */
	public List<Book_tbl> getBookLoans() {
		return bookLoans;
	}
	/**
	 * @param bookLoans the bookLoans to set
	 */
	public void setBookLoans(List<Book_tbl> bookLoans) {
		this.bookLoans = bookLoans;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return PhoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	private String PhoneNo;

}
