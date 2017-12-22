package com.shunan.committeewb.dao;

import java.util.List;
import com.shunan.committeewb.po.NewsType;

public interface NewsTypeMapper {
	
	/**
	 * 查询所有的新闻类别
	 * @return
	 * @throws Exception
	 */
	public List<NewsType> queryAllNewsType() throws Exception;
	
	/**
	 * 根据id查询新闻类别
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NewsType queryNewsTypeByID(int id) throws Exception;
}
