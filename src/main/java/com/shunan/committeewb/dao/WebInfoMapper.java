package com.shunan.committeewb.dao;

import com.shunan.committeewb.po.WebInfo;

/**
 * 网站基本信息dao层
 * @author 李琳茹
 *
 */
public interface WebInfoMapper {
	/**
	 * 查询网站基本信息
	 * @return
	 * @throws Exception
	 */
	public WebInfo queryWebInfo() throws Exception;
	
	/**
	 * 根据网站id查询网站信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WebInfo queryWebInfoByID(int id) throws Exception;
	
	/**
	 * 修改网站信息
	 * @param webInfo
	 * @throws Exception
	 */
	public void updateWebInfo(WebInfo webInfo) throws Exception;
}
