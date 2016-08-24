package com.dao.lpml;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.IUserDao;
import com.entity.User;
import java.sql.PreparedStatement;;

public class UserDaoIpml implements IUserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.
				prepareCall("insert INTO tb_user(name,password,email) VALUES (?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		// TODO Auto-generated method stub
		String updatesql = "update tb_user set name=?,password= ?,email=?where id= ?";
		PreparedStatement ps = conn.prepareCall(updatesql);
		ps.setString(1, user.getName());
		ps.setString(2,user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, user.getId());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		String deletesql= "delete from tb_user where id= ?";
		PreparedStatement ps = conn.prepareCall(deletesql);
		ps.setLong(1, user.getId());
		ps.execute();
	}

}
