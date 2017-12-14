package com.shunan.committeewb.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.HomeMapper;
import com.shunan.committeewb.po.Home;
import com.shunan.committeewb.service.HomeService;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeMapper homeMapper;

	@Override
	public Home queryHome(int id) throws Exception {
		return homeMapper.queryHome(id);
	}

	@Override
	public void updateHome(Home home) throws Exception {
		home.setPublishTime(new Date());
		homeMapper.updateHome(home);
	}
}
