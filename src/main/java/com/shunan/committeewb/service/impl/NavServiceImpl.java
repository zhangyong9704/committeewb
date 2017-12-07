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

	/**
	 * 更新导航栏信息
	 */
	@Override
	public void updateNav(Nav nav) throws Exception {
		navMapper.updateNav(nav);
	}

	/**
	 * 添加导航栏信息
	 */
	@Override
	public void insertNav(Nav nav) throws Exception {
		navMapper.insertNav(nav);
	}

	/**
	 * 删除导航栏信息
	 */
	@Override
	public void deleteNav(int id) throws Exception {
		navMapper.deleteNav(id);
	}

	@Override
	public Nav queryNavByID(int id) throws Exception {
		return navMapper.queryNavByID(id);
	}

}
