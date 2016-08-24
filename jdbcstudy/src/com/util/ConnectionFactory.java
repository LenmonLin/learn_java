package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String jdbcurl;
	private static String user;
	private static String password;
	private static final ConnectionFactory FACTORY = new ConnectionFactory();
	private Connection conn;
	static{
		Properties properties = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			properties.load(in);
		} catch (Exception e) {
			System.out.println("=====配置文件读取错误=======");
		}
		driver = properties.getProperty("driver");
		jdbcurl = properties.getProperty("jdbcurl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	//构造函数
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance(){
		return FACTORY;
	}
	
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(jdbcurl,user,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
