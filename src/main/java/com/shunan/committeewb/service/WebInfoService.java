package com.shunan.committeewb.service;

import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.po.WebInfo;

public interface WebInfoService {
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
	 * @param backgroundFile 
	 * @param titleFile 
	 * @param logoFile 
	 * @param webInfo
	 * @throws Exception
	 */
	public void updateWebInfo(MultipartFile logoFile, MultipartFile titleFile, 
			MultipartFile backgroundFile, WebInfo webInfo) throws Exception;
}
