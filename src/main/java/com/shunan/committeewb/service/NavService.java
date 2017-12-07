package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.Nav;

public interface NavService {
	/**
	 * 查询所有的导航栏信息
	 * @return
	 * @throws Exception
	 */
	public List<Nav> queryAllNavs() throws Exception;
	
	/**
	 * 修改导航栏信息
	 * @param nav
	 * @throws Exception
	 */
	public void updateNav(Nav nav) throws Exception;
	
	/**
	 * 添加导航栏信息
	 * @param nav
	 * @throws Exception
	 */
	public void insertNav(Nav nav) throws Exception;
	
	/**
	 * 根据id查询导航栏信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Nav queryNavByID(int id) throws Exception;
	
	/**
	 * 删除导航栏信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteNav(int id) throws Exception;
}
