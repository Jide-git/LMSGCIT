package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.NoOfCopies;
import com.gcit.lms.objectsTable.NoOfCopies;

public class NoOfCopiesDAO extends GenDAO {

	public NoOfCopiesDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void saveBookCopy(NoOfCopies bookCopy) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_book_Copies (noOfCopies) values (?)", new Object[] { bookCopy.getTotalBookCopies() });
	}


	public void updatesBookCopies(NoOfCopies bookCopy) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_book_Copies SET noOfCopies = ? where bookId = ?",
				new Object[] { bookCopy.getTotalBookCopies(), bookCopy.getBookId() });

	}

	public List<NoOfCopies> readAllCopies() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_book_Copies", null);
	}
	
	public List<NoOfCopies> read(String noOfCopies) throws ClassNotFoundException, SQLException {
		noOfCopies = "%"+noOfCopies+"%";
		return readData("SELECT * FROM tbl_book_Copies where noOfCopies like ?", new Object[]{noOfCopies});
	}

	@Override
	public List<NoOfCopies> extractData(ResultSet rs) throws SQLException {
		List<NoOfCopies> bookCopyies = new ArrayList<>();
		while (rs.next()) {
			NoOfCopies bc = new NoOfCopies();
			bc.setTotalBookCopies(rs.getInt("noOfCopies"));
			bookCopyies.add(bc);
		}
		return bookCopyies;
}

}
