package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.gcit.lms.objectsTable.BookLoan_tbl;

public class BookLoanDAO extends GenDAO{

	public BookLoanDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void saveBookLoan(BookLoan_tbl loan) throws ClassNotFoundException, SQLException {
		 //INSERT INTO tbl_book_loans (bookId,branchId,cardNo,dateOut) VALUES (?, ?, ?, ?);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();        
		String dateOut = df.format(today);

		saveData("INSERT INTO tbl_book_loans (bookId,branchId,cardNo,dateOut) VALUES (?, ?, ?, ?)", new Object[] { loan.getBookId(), loan.getBranchId(), loan.getCardNo(),dateOut});
	}
	


	

	public void deleteBookLoan(BookLoan_tbl loan) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_book_loans where cardNo = ?", new Object[] { loan.getCardNo() });
	}

	public List<BookLoan_tbl> readAllBorrowers() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_book_loans", null);
	}
	
	public List<BookLoan_tbl> read(String name) throws ClassNotFoundException, SQLException {
		name = "%"+name+"%";
		return readData("SELECT * FROM tbl_book_loans where name like ?", new Object[]{name});
	}

	@Override
	public List<BookLoan_tbl> extractData(ResultSet rs) throws SQLException {
		List<BookLoan_tbl> loans = new ArrayList<>();
		while (rs.next()) {
			BookLoan_tbl b = new BookLoan_tbl();
			b.setCardNo(rs.getInt("cardNo"));
			b.setDateIn(rs.getString("dateIn"));
			loans.add(b);
		}
		return loans;
}
}



