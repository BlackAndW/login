package com.wuzizhong.test.Service;

import java.sql.SQLException;
import java.util.Map;
import com.wuzizhong.test.entity.User;

public interface LoginService {
//	判断用户名密码是否正确
	public Map<String, Object> check(User user) throws SQLException;
}
