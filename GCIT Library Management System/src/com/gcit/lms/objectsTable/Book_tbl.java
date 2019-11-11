package com.gcit.lms.objectsTable;

import java.util.List;

public class Book_tbl {
	private Integer bookId;
	private String title;
	private List<Author_tbl> authors;
	private List<Genre_tbl> genres;
	private Publisher_tbl publisher;
	private Integer copies;
	/**
	 * @return the copies
	 */
	public Integer getCopies() {
		return copies;
	}
	/**
	 * @param copies the copies to set
	 */
	public void setCopies(Integer copies) {
		this.copies = copies;
	}
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the authors
	 */
	public List<Author_tbl> getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author_tbl> authors) {
		this.authors = authors;
	}
	/**
	 * @return the genres
	 */
	public List<Genre_tbl> getGenres() {
		return genres;
	}
	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<Genre_tbl> genres) {
		this.genres = genres;
	}
	/**
	 * @return the publisher
	 */
	public Publisher_tbl getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher_tbl publisher) {
		this.publisher = publisher;
	}

}
