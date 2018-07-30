package com.wuzizhong.test.Service.Impl;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.wuzizhong.test.Service.LoginService;
import com.wuzizhong.test.dao.LoginDao;
import com.wuzizhong.test.dao.DaoImpl.LoginDaoImpl;
import com.wuzizhong.test.entity.User;

public class LoginServiceImpl implements LoginService{

	private LoginDao loginDao = new LoginDaoImpl();
	String msg = "";
	
	@Override
	public Map<String, Object> check(User user) throws SQLException {
		Map<String,Object> User = new HashMap<>();
		String msg = "";
//		从数据库中查找用户信息
		loginDao.getUserInfo(user);
		
//		判断用户名是否正确
		String i = loginDao.getUsername(user);
		if (user.getUsername().equals(i)) {
			User.put("username", i);
//			判断密码是否正确
			String j = loginDao.getPassword(user);
			String k = loginDao.getRole(user);
			
			if (user.getPassword().equals(j)) {
				User.put("password", j);
				User.put("Role", k);
			}else {
				msg = "密码错误，请重新输入";
			}
		}else {
			msg = "用户名错误，请重新输入";
		}
	
//		将结果保存在User中
		User.put("msg", msg);
		return User;
	}
}
