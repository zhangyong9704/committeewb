package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.NewsType;

public interface NewsTypeService {
	
	/**
	 * 查询所有的新闻类别
	 * @return
	 * @throws Exception
	 */
	public List<NewsType> queryAllNewsType() throws Exception;
}
