package com.wuzizhong.test.Service.Impl;

import java.sql.SQLException;
import com.wuzizhong.test.Service.RegisterService;
import com.wuzizhong.test.dao.RegisterDao;
import com.wuzizhong.test.dao.DaoImpl.RegisterDaoImpl;
import com.wuzizhong.test.entity.User;

public class RegisterServiceImpl implements RegisterService {
	private RegisterDao registerDao = new RegisterDaoImpl();
	private int state;
	
//	�ж��û����������Ƿ�Ϊ�գ�����״ֵ̬�ʹ�����Ϣ
	@Override
	public int checkResult(User user) {
		try {
			state = registerDao.addUser(user.getUsername(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
