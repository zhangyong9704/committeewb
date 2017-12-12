package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.PageResult;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.NewsService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

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
	public Result<News> queryPageNews(String typeIDs,Integer chooseStatus,
			Integer offset,Integer limit,String order) throws Exception{
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		long count = 0;
		
		if(chooseStatus == null){
			return new Result<News>(100, "参数不合法！", list);
		}
		
		try {
			list = newsService.queryPageNews(typeIDs,chooseStatus,offset,limit,order);
			count = newsService.queryNewsTotal(typeIDs,chooseStatus);
			result = new PageResult<News>(200, "查询成功！", list, count);
		} catch (Exception e) {
			result = new PageResult<News>(100, "查询失败！", list, count);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 删除新闻
	 * @param typeIDs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteNews")
	@ResponseBody
	public Result<String> deleteNews(String ids) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		if(ids==null || ids.equals("")){
			return new Result<String>(100, "请先选择要删除的新闻！", list);
		}
		
		try {
			newsService.deleteNews(ids);
			result = new Result<String>(200, "删除新闻成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除新闻失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("/insertNews")
	@ResponseBody
	public Result<? extends Object> insertNews(News news,MultipartFile picFile,
			MultipartFile attachmentFiles[]) throws Exception{
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(picFile, 
					CommonUtils.NEWS_WIDTH, CommonUtils.NEWS_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		
		if(news.getId()==0){
			//添加新闻
			try {
				int newsID = newsService.insertNews(news,picFile,attachmentFiles);
				News returnNews = newsService.queryNewsByID(newsID);
				list.add(returnNews);
				result = new Result<News>(200, "添加新闻成功！", list);
			} catch (Exception e) {
				result = new Result<News>(100, "添加新闻失败！", list);
				e.printStackTrace();
			}
		}else{
			//编辑新闻
			try {
				newsService.updateNews(news,picFile,attachmentFiles);
				result = new Result<News>(200, "修改新闻成功！", list);
			} catch (Exception e) {
				result = new Result<News>(100, "修改新闻失败！", list);
				e.printStackTrace();
			}
		}
		return result;
	}

}