package com.shunan.committeewb.dao;

import com.shunan.committeewb.po.Home;

public interface HomeMapper {
	
	/**
	 * 查询规章制度、工作标准、通讯录、风采录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Home queryHome(int id) throws Exception;
	
	/**
	 * 修改 规章制度、工作标准、通讯录、风采录
	 * @param home
	 * @throws Exception
	 */
	public void updateHome(Home home) throws Exception;

}
