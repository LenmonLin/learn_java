package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionTest {
	// 连接数据库
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 插入一条记录
	public static void insertUserDate(Connection conn) throws SQLException {

		String sql = "insert into tb_user(id,name,password,email)" + "values(10,'tom','123','tom@google.com')";
		Statement st = conn.createStatement();
		int count = st.executeUpdate(sql);
		System.out.println("用户向用户数据表中插入了" + count + "条记录");

	}

	public static void insertAddressDate(Connection conn) throws SQLException{
	
			String sql = "insert into tb_address(id,city,country,user_id)" + "values(1,'shanghai','china','10')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("用户向地址数据表中插入了" + count + "条记录");

	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);//设置为禁止自动提交
			insertUserDate(conn);
			insertAddressDate(conn);
			conn.commit();
		} catch (Exception e1) {
			System.out.println("======捕获到SQL异常========");
			e1.printStackTrace();
		}
		try {
			conn.rollback();
			System.out.println("=======事物回滚成功======");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		finally {
			try {
				if(conn != null){
					conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
