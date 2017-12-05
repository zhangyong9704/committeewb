package com.shunan.committeewb.dao;

import java.util.List;

import com.shunan.committeewb.po.Nav;

public interface NavMapper {
	/**
	 * 查询所有的导航栏信息
	 * @return
	 * @throws Exception
	 */
	public List<Nav> queryAllNavs() throws Exception;
}
