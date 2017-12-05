package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.NavMapper;
import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.service.NavService;

@Service
@Transactional
public class NavServiceImpl implements NavService {
	@Autowired
	private NavMapper navMapper;

	/**
	 * 查询所有的导航栏信息
	 */
	@Override
	public List<Nav> queryAllNavs() throws Exception {
		return navMapper.queryAllNavs();
	}

}
