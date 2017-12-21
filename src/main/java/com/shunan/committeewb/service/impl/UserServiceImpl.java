package com.shunan.committeewb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shunan.committeewb.dao.UserMapper;
import com.shunan.committeewb.po.User;
import com.shunan.committeewb.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public User queryUserByAccount(String account) throws Exception {
		return userMapper.queryUserByAccount(account);
	}

	//根据用户名密码查询用户信息
	@Override
	public User queryUserByInfo(User user) throws Exception {
		return userMapper.queryUserByInfo(user);
	}
}
