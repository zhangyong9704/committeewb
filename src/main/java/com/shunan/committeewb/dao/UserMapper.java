package com.shunan.committeewb.dao;

import com.shunan.committeewb.po.User;

public interface UserMapper {
	//根据用户账号查询用户信息
	public User queryUserByAccount(String account) throws Exception;
}
