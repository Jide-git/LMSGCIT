package com.gcit.lms.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.objectsTable.Publisher_tbl;

public class PublisherDAO extends GenDAO {

	public PublisherDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	

	public void savePublisher(Publisher_tbl publisher) throws ClassNotFoundException, SQLException {
		saveData("INSERT INTO tbl_publisher (publisherName) values (?)", new Object[] { publisher.getPubName() });
	}


	public void updatePublisher(Publisher_tbl publisher) throws SQLException, ClassNotFoundException {
		saveData("UPDATE tbl_publisher SET publisherName = ? where publisherId = ?",
				new Object[] { publisher.getPubName(), publisher.getPubId() });

	}

	public void deletePublisher(Publisher_tbl publisher) throws ClassNotFoundException, SQLException {
		saveData("delete from tbl_publisher where publisherId = ?", new Object[] { publisher.getPubId() });
	}

	public List<Publisher_tbl> readAllPublishers() throws ClassNotFoundException, SQLException {
		return readData("SELECT * FROM tbl_publisher", null);
	}
	
	public List<Publisher_tbl> read(String publisherName) throws ClassNotFoundException, SQLException {
		publisherName = "%"+publisherName+"%";
		return readData("SELECT * FROM tbl_publisher where publisherName like ?", new Object[]{publisherName});
	}

	@Override
	public List<Publisher_tbl> extractData(ResultSet rs) throws SQLException {
		List<Publisher_tbl> publishers = new ArrayList<>();
		while (rs.next()) {
			Publisher_tbl b = new Publisher_tbl();
			b.setPubId(rs.getInt("publisherId"));
			b.setPubName(rs.getString("publisherName"));
			publishers.add(b);
		}
		return publishers;
	}

}
