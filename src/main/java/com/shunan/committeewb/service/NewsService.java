package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.News;

public interface NewsService {
	/**
	 * 查询首页需要展示的重点专注、文件通知、团青快讯等
	 * @param newsTypeID
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<News> queryHomeNews(int newsTypeID,int limit) throws Exception;

	/**
	 * 分页查询所有的新闻 or 重点专注、公告通知等等
	 * @param typeID
	 * @param chooseStatus 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<News> queryPageNews(String typeIDs, int chooseStatus, 
			int currentPage, int pageSize, int sort) throws Exception;

	/**
	 * 查询一共多少条新闻 or 重点专注、公告通知等等
	 * @param typeID
	 * @param chooseStatus 
	 * @return
	 * @throws Exception
	 */
	public long queryNewsTotal(String typeIDs, int chooseStatus) throws Exception;
}
