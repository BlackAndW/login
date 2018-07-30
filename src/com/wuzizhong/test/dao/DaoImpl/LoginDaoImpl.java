package com.wuzizhong.test.dao.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wuzizhong.test.Util.DBUtil;
import com.wuzizhong.test.dao.LoginDao;
import com.wuzizhong.test.entity.User;
import com.wuzizhong.test.entity.UserInfo;

public class LoginDaoImpl implements LoginDao {
	DBUtil dbUtil = new DBUtil();
	
	private UserInfo userInfo = new UserInfo();
	
	public void getUserInfo(User user) throws SQLException {
		dbUtil.getConn();
		Object[] obj = new Object[1];
		List<String> userInfoList = new ArrayList<>();
		obj[0] = user.getUsername();
		String sql = "select * from userinfo where username = ?";
		ResultSet rs = dbUtil.select(sql, obj);
		if (rs.next()) {
			for(int i = 1;i <= 3;i++) {
				userInfoList.add(rs.getString(i));
			}
			userInfo.setUserInfos(userInfoList);
			dbUtil.close();
		}else {
			userInfoList.add("noUser");
			userInfo.setUserInfos(userInfoList);
		}
		dbUtil.close();
//		return userInfo;
		
	}
	
	public String getUsername(User user) throws SQLException {
		return this.userInfo.getUserInfos().get(0);
	}
	
	public String getPassword(User user) throws SQLException {
		return this.userInfo.getUserInfos().get(1);
	}
	
	public String getRole(User user) throws SQLException {
		return this.userInfo.getUserInfos().get(2);
	}

}
