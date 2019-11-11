package com.gcit.lms.objectsTable;

import java.util.List;

public class Publisher_tbl {
	
	private Integer pubId;
	private String 	pubName;
	private List<Book_tbl> bookTitle;
	private String pubAdress;
	private String pubPhoneNo;
	/**
	 * @return the pubId
	 */
	public Integer getPubId() {
		return pubId;
	}
	/**
	 * @param pubId the pubId to set
	 */
	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}
	/**
	 * @return the pubAdress
	 */
	public String getPubAdress() {
		return pubAdress;
	}
	/**
	 * @param pubAdress the pubAdress to set
	 */
	public void setPubAdress(String pubAdress) {
		this.pubAdress = pubAdress;
	}
	/**
	 * @return the pubPhoneNo
	 */
	public String getPubPhoneNo() {
		return pubPhoneNo;
	}
	/**
	 * @param pubPhoneNo the pubPhoneNo to set
	 */
	public void setPubPhoneNo(String pubPhoneNo) {
		this.pubPhoneNo = pubPhoneNo;
	}
	/**
	 * @return the pubName
	 */
	public String getPubName() {
		return pubName;
	}
	/**
	 * @param pubName the pubName to set
	 */
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	/**
	 * @return the bookTitle
	 */
	public List<Book_tbl> getBookTitle() {
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(List<Book_tbl> bookTitle) {
		this.bookTitle = bookTitle;
	}
	
}
