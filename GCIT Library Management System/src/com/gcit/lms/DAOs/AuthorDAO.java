package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Author_tbl;

public class AuthorDAO extends GenDAO{

	public AuthorDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void saveAuthor(Author_tbl author) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_author (authorName) values (?)", new Object[] { author.getAuthorName() });
	}

	public void updateAuthor(Author_tbl author) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_author SET authorName = ? where authorId = ?",
				new Object[] { author.getAuthorName(), author.getAuthorId() });

	}

	public void deleteAuthor(Author_tbl author) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_author where authorId = ?", new Object[] { author.getAuthorId() });
	}

	public List<Author_tbl> readAllAuthors() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_author", null);
	}
	
	public List<Author_tbl> readAllAuthorsByName(String authorName) throws ClassNotFoundException, SQLException {
		authorName = "%"+authorName+"%";
		return readData("SELECT * FROM tbl_author where authorName like ?", new Object[]{authorName});
	}

	@Override
	public List<Author_tbl> extractData(ResultSet rs) throws SQLException {
		List<Author_tbl> authors = new ArrayList<>();
		while (rs.next()) {
			Author_tbl a = new Author_tbl();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			authors.add(a);
		}
		return authors;
	}

}
