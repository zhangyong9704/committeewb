package com.shunan.committeewb.service;

import com.shunan.committeewb.po.User;

public interface UserService {
	//根据用户账号查询用户信息
	public User queryUserByAccount(String account) throws Exception;
	//根据用户名密码查询用户信息
	public User queryUserByInfo(User user) throws Exception;
}
