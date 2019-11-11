package com.gcit.lms.DAOs;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



public abstract class GenDAO<T> {

	public final String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	public final String username = "root";
	public final String password = "@31doddt19C";
	public final String driver = "com.mysql.cj.jdbc.Driver";
	
	public static Connection conn = null;
	
	public GenDAO(Connection conn){
		this.conn = conn;
	}	
	public void saveData(String sql, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		for(Object o: vals){
			pstmt.setObject(index, o);
			index++;
		}
		pstmt.executeUpdate();
	}
	
	public Integer saveWithID(String sql, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int index = 1;
		for(Object o: vals){
			pstmt.setObject(index, o);
			index++;
		}
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			return rs.getInt(1); //check if it is 1 or 0;
		}
		return null;
	}
	
	public List<T> readData(String sql, Object[] vals) throws ClassNotFoundException, SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		if (vals != null) {
			for(Object o: vals){
				pstmt.setObject(index, o);
				index++;
			}
		
		}
		ResultSet rs = pstmt.executeQuery();
		return extractData(rs);
	}
	
	public abstract List<T> extractData(ResultSet rs) throws SQLException;

}
