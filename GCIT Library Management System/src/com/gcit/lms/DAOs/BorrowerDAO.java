package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Borrower_tbl;

public class BorrowerDAO extends GenDAO{

	public BorrowerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void saveBorrower(Borrower_tbl borrower) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_borrower (name) values (?)", new Object[] { borrower.getName() });
	}


	public void updateBorrower(Borrower_tbl borrower) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_borrower SET name = ? where cardNo = ?",
				new Object[] { borrower.getName(), borrower.getCardNo() });

	}

	public void deleteBorrower(Borrower_tbl borrower) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_borrower where cardNo = ?", new Object[] { borrower.getCardNo() });
	}

	public List<Borrower_tbl> readAllBorrowers() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_borrower", null);
	}
	
	public List<Borrower_tbl> read(String name) throws ClassNotFoundException, SQLException {
		name = "%"+name+"%";
		return readData("SELECT * FROM tbl_borrower where name like ?", new Object[]{name});
	}

	@Override
	public List<Borrower_tbl> extractData(ResultSet rs) throws SQLException {
		List<Borrower_tbl> borrowers = new ArrayList<>();
		while (rs.next()) {
			Borrower_tbl b = new Borrower_tbl();
			b.setCardNo(rs.getInt("cardNo"));
			b.setName(rs.getString("name"));
			borrowers.add(b);
		}
		return borrowers;
	}


}
