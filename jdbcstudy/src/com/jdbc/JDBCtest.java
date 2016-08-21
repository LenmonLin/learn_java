package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCtest {
	public static void main(String[] args) {
		String sql = "SELECT * FROM tb_user";
		Connection conn = null;
		Statement st= null;
		ResultSet rs= null; 
		
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","root");
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("email"));
			}
		} catch (Exception	 e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			try {
				st.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
			try {
				conn.close();
			} catch (Exception e4) {
				// TODO: handle exception
			}
		}
	}
}
