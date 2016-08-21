package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JDBCDML {
	//连接数据库
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//插入一条记录
	public static void	insert() {
		Connection conn = getConnection();
		try {
			String sql="insert into tb_user(name,password,email)"+
					"values('tom','123','tom@google.com')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("用户想数据表中插入了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//更新一条记录
	public static void	update() {
		Connection conn = getConnection();
		try {
			String sql="update tb_user set email='change@google.com' where name = 'tom'";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("用户想数据表中更新了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//删除一条记录
	public static void	delete() {
		Connection conn = getConnection();
		try {
			String sql="delete from tb_user where name = 'tom'";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("用户想数据表中删除了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		//insert();
		//update();
		delete();
	}
}
