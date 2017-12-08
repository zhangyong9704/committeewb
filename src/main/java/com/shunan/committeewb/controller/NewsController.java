package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.PageResult;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.NewsService;

/**
 * 新闻
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	/**
	 * 分页查询新闻 or 重点专注、公告通知等
	 * @param typeID
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryPageNews")
	@ResponseBody
	public Result<News> queryPageNews(String typeID,String chooseStatus,
			String currentPage,String pageSize,String sort) throws Exception{
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		long count = 0;
		
		if(typeID==null || chooseStatus==null || currentPage==null || pageSize==null || sort==null){
			return new Result<News>(100, "参数不合法！", list);
		}
		
		try {
			list = newsService.queryPageNews(typeID,Integer.parseInt(chooseStatus),
					Integer.parseInt(currentPage),Integer.parseInt(pageSize),Integer.parseInt(sort));
			count = newsService.queryNewsTotal(typeID,Integer.parseInt(chooseStatus));
			result = new PageResult<News>(200, "查询成功！", list, count);
		} catch (Exception e) {
			result = new PageResult<News>(100, "查询失败！", list, count);
			e.printStackTrace();
		}
		
		return result;
	}

}
