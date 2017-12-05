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
}
