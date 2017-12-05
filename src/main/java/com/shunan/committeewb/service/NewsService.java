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
}
