package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.NewsType;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.NewsTypeService;

@Controller
@RequestMapping("/newsType")
public class NewsTypeController {
	@Autowired
	private NewsTypeService newsTypeService;
	
	/**
	 * 查询所有的新闻类别
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllNewsType")
	@ResponseBody
	private Result<NewsType> queryAllNewsType() throws Exception{
		Result<NewsType> result = null;
		List<NewsType> list = new ArrayList<NewsType>();
		
		try {
			list = newsTypeService.queryAllNewsType();
			result = new Result<NewsType>(200, "查询新闻类别成功！", list);
		} catch (Exception e) {
			result = new Result<NewsType>(100, "查询新闻类别失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
}
