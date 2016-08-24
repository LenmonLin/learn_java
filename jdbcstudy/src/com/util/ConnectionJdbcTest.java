package com.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionJdbcTest {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.makeConnection();
		System.out.println(conn.getAutoCommit());
	}

}
