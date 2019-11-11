package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Branch_tbl;

public class BranchDAO extends GenDAO{

	public BranchDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void saveBranch(Branch_tbl branch) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_library_branch (branchName) values (?)", new Object[] { branch.getBranchName() });
	}


	public void updateBranch(Branch_tbl branch) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_library_branch SET branchName = ?, branchAddress = ? where branchId = ?",
				new Object[] { branch.getBranchName(),branch.getBranchAdress(), branch.getBranchId() });
		System.out.println(branch.getBranchName());

		

	}

	public void deleteBranch(Branch_tbl branch) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_library_branch where branchId = ?", new Object[] { branch.getBranchId() });
	}
	
	public List<Branch_tbl> readAllBranches() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_library_branch", null);
	}
	
	public List<Branch_tbl> read(String branchName) throws ClassNotFoundException, SQLException {
		branchName = "%"+branchName+"%";
		return readData("SELECT * FROM tbl_library_branch where branchName like ?", new Object[]{branchName});
	}

	@Override
	public List<Branch_tbl> extractData(ResultSet rs) throws SQLException {
		List<Branch_tbl> branches = new ArrayList<>();
		while (rs.next()) {
			Branch_tbl b = new Branch_tbl();
			b.setBranchId(rs.getInt("branchId"));
			b.setBranchName(rs.getString("branchName"));
			b.setBranchAdress(rs.getString("branchAddress"));
			branches.add(b);
		}
		return branches;
	}


}
