package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Genre_tbl;

public class GenreDAO extends GenDAO {

	public GenreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	
	public void saveGenre(Genre_tbl genre) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_genre (genre_Name) values (?)", new Object[] { genre.getGenreType() });
	}

	public void updateGenre(Genre_tbl genre) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_genre SET genre_Name = ? where genre_Id = ?",
				new Object[] { genre.getGenreType(), genre.getGenreId() });

	}

	public void deleteGenre(Genre_tbl genre) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_genre where genre_Id = ?", new Object[] { genre.getGenreId() });
	}

	public List<Genre_tbl> readAllGenres() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_genre", null);
	}
	
	public List<Genre_tbl> read(String genre_Name) throws ClassNotFoundException, SQLException {
		genre_Name = "%"+genre_Name+"%";
		return readData("SELECT * FROM tbl_genre where genre_Name like ?", new Object[]{genre_Name});
	}

	@Override
	public List<Genre_tbl> extractData(ResultSet rs) throws SQLException {
		List<Genre_tbl> genres = new ArrayList<>();
		while (rs.next()) {
			Genre_tbl b = new Genre_tbl();
			b.setGenreId(rs.getInt("genre_Id"));
			b.setGenreType(rs.getString("genre_Name"));
			genres.add(b);
		}
		return genres;
	}
}
