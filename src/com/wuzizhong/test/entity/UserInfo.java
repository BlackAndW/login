package com.wuzizhong.test.entity;

import java.io.Serializable;
import java.util.List;
 
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<String> userInfos;

	public List<String> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<String> userInfos) {
		this.userInfos = userInfos;
	}


}
