package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Book_tbl;
import com.gcit.lms.objectsTable.Branch_tbl;

public class BookDAO extends GenDAO {

	public BookDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	

	public void saveBook(Book_tbl book) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_book (title) values (?)", new Object[] { book.getTitle() });
	}

	public void updateBook(Book_tbl book) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_book SET title = ? where bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });

	}

	public void deleteBook(Book_tbl book) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_book where bookId = ?", new Object[] { book.getBookId() });
	}

	public List<Book_tbl> readAllBooks() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_book", null);
	}
	
	public List<Book_tbl> read(String title) throws ClassNotFoundException, SQLException {
		title = "%"+title+"%";
		return readData("SELECT * FROM tbl_book where title like ?", new Object[]{title});
	}
	public List<Book_tbl> readAllBooksByBranch(Branch_tbl branch) throws ClassNotFoundException, SQLException {
		return readData(" SELECT tbl_book.title, tbl_book.bookId FROM tbl_book_copies"
				+ "	INNER JOIN tbl_book ON tbl_book_copies.bookId = tbl_book.bookId "
				+ "	INNER JOIN tbl_library_branch ON tbl_book_copies.branchId = tbl_library_branch.branchId "
				+ "	WHERE  tbl_library_branch.branchName = ? ", new Object[] {branch.getBranchName()});
	}


	@Override
	public List<Book_tbl> extractData(ResultSet rs) throws SQLException {
		List<Book_tbl> books = new ArrayList<>();
		while (rs.next()) {
			Book_tbl b = new Book_tbl();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		return books;
	}
	

}
