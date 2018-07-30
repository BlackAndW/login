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
//		�����ݿ��в����û���Ϣ
		loginDao.getUserInfo(user);
		
//		�ж��û����Ƿ���ȷ
		String i = loginDao.getUsername(user);
		if (user.getUsername().equals(i)) {
			User.put("username", i);
//			�ж������Ƿ���ȷ
			String j = loginDao.getPassword(user);
			String k = loginDao.getRole(user);
			
			if (user.getPassword().equals(j)) {
				User.put("password", j);
				User.put("Role", k);
			}else {
				msg = "�����������������";
			}
		}else {
			msg = "�û�����������������";
		}
	
//		�����������User��
		User.put("msg", msg);
		return User;
	}
}
