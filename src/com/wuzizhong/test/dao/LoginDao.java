package com.wuzizhong.test.dao;

import java.sql.SQLException;

import com.wuzizhong.test.entity.User;

public interface LoginDao {
	public void getUserInfo(User user) throws SQLException;
	
	public String getUsername(User user) throws SQLException;
	
	public String getPassword(User user) throws SQLException;
	
	public String getRole(User user) throws SQLException;
}
