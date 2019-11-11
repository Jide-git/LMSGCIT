package com.gcit.lms.objectsTable;

import java.util.List;

public class Genre_tbl {
	private Integer genreId;
	private String 	genreType;
	private List<Book_tbl> Bookgenres;
	/**
	 * @return the genreId
	 */
	public Integer getGenreId() {
		return genreId;
	}
	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	/**
	 * @return the genreType
	 */
	public String getGenreType() {
		return genreType;
	}
	/**
	 * @param genreType the genreType to set
	 */
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	/**
	 * @return the bookgenres
	 */
	public List<Book_tbl> getBookgenres() {
		return Bookgenres;
	}
	/**
	 * @param bookgenres the bookgenres to set
	 */
	public void setBookgenres(List<Book_tbl> bookgenres) {
		Bookgenres = bookgenres;
	}
	
	
	

}
