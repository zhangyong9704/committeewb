package com.shunan.committeewb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.NewsMapper;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;

	/**
	 * 查询首页需要展示的重点专注、文件通知、团青快讯等
	 */
	@Override
	public List<News> queryHomeNews(int newsTypeID, int limit) throws Exception {
		return newsMapper.queryHomeNews(newsTypeID, limit);
	}

	/**
	 * 分页查询所有的新闻 or 重点专注、公告通知等等
	 */
	@Override
	public List<News> queryPageNews(String typeIDs, int chooseStatus, 
			int currentPage, int pageSize, int sort) throws Exception {
		int begin = (currentPage-1)*pageSize;
		List<News> newsList = new ArrayList<News>();
		
		newsList = newsMapper.queryPageNews(typeIDs, chooseStatus, begin, pageSize, sort);
		return newsList;
	}

	/**
	 * 查询一共多少条新闻 or 重点专注、公告通知等等
	 */
	@Override
	public long queryNewsTotal(String typeIDs, int chooseStatus) throws Exception {
		long count = 0;
		count = newsMapper.queryNewsTotal(typeIDs, chooseStatus);
		return count;
	}
}
