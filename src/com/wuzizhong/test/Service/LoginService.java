package com.wuzizhong.test.Service;

import java.sql.SQLException;
import java.util.Map;
import com.wuzizhong.test.entity.User;

public interface LoginService {
//	�ж��û��������Ƿ���ȷ
	public Map<String, Object> check(User user) throws SQLException;
}
