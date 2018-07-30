package com.wuzizhong.test.dao;

import java.sql.SQLException;

public interface RegisterDao {
	public int addUser(String username,String password) throws SQLException;
}
