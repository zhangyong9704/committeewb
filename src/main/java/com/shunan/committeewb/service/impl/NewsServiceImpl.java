package com.shunan.committeewb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.NewsMapper;
import com.shunan.committeewb.dao.RollImgMapper;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private RollImgMapper rollImgMapper;

	/**
	 * 查询首页需要展示的重点专注、文件通知、团青快讯等
	 */
	@Override
	public List<News> queryHomeNews(int newsTypeID, int limit) throws Exception {
		return newsMapper.queryHomeNews(newsTypeID, limit);
	}

	/**
	 * 查询一共多少条新闻 or 重点专注、公告通知等等
	 */
	@Override
	public long queryNewsTotal(String typeIDs, int chooseStatus) throws Exception {
		long count = 0;
		List<Integer> typeIDList = transferStringToIntArr(typeIDs);
		count = newsMapper.queryNewsTotal(typeIDList, chooseStatus);
		return count;
	}

	/**
	 * 分页查询所有的新闻 or 重点专注、公告通知等等
	 */
	@Override
	public List<News> queryPageNews(String typeIDs, Integer chooseStatus, 
			Integer offset, Integer limit, String order) throws Exception {
		if(offset == null){
			offset = 0;
		}
		if(limit == null){
			limit = 10;
		}
		if(order == null){
			order = "asc";
		}
		
		List<Integer> typeIDList = transferStringToIntArr(typeIDs);
		
		List<News> newsList = new ArrayList<News>();
		newsList = newsMapper.queryPageNews(typeIDList, chooseStatus, offset, limit, order);
		return newsList;
	}
	
	/**
	 * 删除新闻
	 */
	@Override
	public void deleteNews(String ids) throws Exception {
		List<Integer> idList = transferStringToIntArr(ids);
		rollImgMapper.deleteRollImg(idList);
		newsMapper.deleteNews(idList);
	}
	
	/**
	 * 将String转换为List
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private List<Integer> transferStringToIntArr(String str) throws Exception{
		String[] strArr = str.trim().split(",");
		List<Integer> list = new ArrayList<Integer>();
		if(strArr.length>0){
			for(String s:strArr){
				if(!s.equals("")){
					list.add(Integer.parseInt(s));
				}
			}
		}
		return list;
	}
}
