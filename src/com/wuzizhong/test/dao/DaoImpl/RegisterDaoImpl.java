package com.wuzizhong.test.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wuzizhong.test.Util.DBUtil;
import com.wuzizhong.test.dao.RegisterDao;

public class RegisterDaoImpl implements RegisterDao{
	
	
	public int addUser(String username,String password) throws SQLException {
		int state = 0;
		DBUtil dbUtil = new DBUtil();
//		dbUtil.getConn();
		Object[] obj = new Object[2];
		obj[0] = username;
		obj[1] = password;
		
//		判断用户名和密码是否已被注册
		String sql1 = "select username,password from userinfo";
		ResultSet rs = dbUtil.select(sql1);
		while(rs.next()) {
			if (username.equals(rs.getString("username"))) {
				state = 1;
				return state;
				}
			if (password.equals(rs.getString("password"))) {
				state = 2;
				return state;
			}
		}
		
//		未被注册则向数据库添加新用户
		String sql = "insert into userinfo values(?,?,'user')";
		dbUtil.update(sql, obj);
		return state;
	}
}
