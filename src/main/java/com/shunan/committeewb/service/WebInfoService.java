package com.shunan.committeewb.service;

import com.shunan.committeewb.po.WebInfo;

public interface WebInfoService {
	/**
	 * 查询网站基本信息
	 * @return
	 * @throws Exception
	 */
	public WebInfo queryWebInfo() throws Exception;
}
