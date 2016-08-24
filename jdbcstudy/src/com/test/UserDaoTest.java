package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.IUserDao;
import com.dao.lpml.UserDaoIpml;
import com.entity.User;
import com.util.ConnectionFactory;

public class UserDaoTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			IUserDao iUserDao = new UserDaoIpml();
			User tom = new User();
			tom.setName("tom");
			tom.setPassword("123");
			tom.setEmail("123@qq.com");
			
			iUserDao.save(conn, tom);
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
