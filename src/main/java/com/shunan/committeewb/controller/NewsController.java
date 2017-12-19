package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * 写文章
	 * @param news
	 * @param picFile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/draft/{id}")
	@ResponseBody
	public Result<? extends Object> insertNews(News news,MultipartFile picFile) throws Exception{
		
/*		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			News news2 = newsService.queryNewsByID(news.getId());
			Result<String> picResult = null;
			switch (news2.getNewsTypeID()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				picResult = FileUtil.checkFile(picFile, 
						CommonUtils.ROLLIMG_WIDTH, CommonUtils.ROLLIMG_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
				break;
			case 8:
				break;
			case 6:
				picResult = FileUtil.checkFile(picFile, 
						CommonUtils.ZTHD_WIDTH, CommonUtils.ZTHD_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
				break;
			case 7:
				picResult = FileUtil.checkFile(picFile, 
						CommonUtils.QCJY_WIDTH, CommonUtils.QCJY_HEIGHT, CommonUtils.FILE_MAXSIZE);
				if(picResult.getCode()!=200){
					return picResult;
				}
				break;

			default:
				break;
			}
		}*/
		
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		
		//没有请求体时：用户直接copy url并打开一个新的页面，新页面请求数据，返回json数据
		if(news.getTitle()==null && news.getPicUrl()==null && news.getContent()==null && news.getNewsTypeID()==0 &&
				(picFile==null || picFile.getOriginalFilename()==null || picFile.getOriginalFilename().equals(""))){
			try {
				News returnNews = newsService.queryNewsByID(news.getId());
				if(returnNews != null){
					list.add(returnNews);
					result = new Result<News>(200, "查询新闻信息成功！", list);
				}else{
					result = new Result<News>(100, "新闻不存在！", list);
				}
			} catch (Exception e) {
				result = new Result<News>(100, "查询新闻信息失败！", list);
				e.printStackTrace();
			}
			return result;
		}
		
		//有请求体时2种情况
		if(news.getId()==-1){
			//添加新闻
			try {
				int newsID = newsService.insertNews(news,picFile);
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
				newsService.updateNews(news,picFile);
				News returnNews = newsService.queryNewsByID(news.getId());
				list.add(returnNews);
				result = new Result<News>(200, "修改新闻成功！", list);
			} catch (Exception e) {
				result = new Result<News>(100, "修改新闻失败！", list);
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 编辑新闻时，用户直接copy url并打开一个新的页面，返回前端该页面
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,Model model) throws Exception{
		News news = newsService.queryNewsByID(id);
		if(news == null){
			return "error/404";
		}
		model.addAttribute("id", id);
		return "write";
	}
	
	/**
	 * to写文章 页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/write")
	public String write() throws Exception{
		return "write";
	}
	
	/**
	 * 发布新闻
	 * @param news
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publishNews")
	@ResponseBody
	public Result<String> publishNews(News news,Integer isRollImg) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		try {
			newsService.publishNews(news,isRollImg);
			result = new Result<String>(200, "发布新闻成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "发布新闻失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 前端 查询新闻,访问量+1
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryNews/{id}")
	@ResponseBody
	public Result<News> queryNews(@PathVariable("id") Integer id) throws Exception{
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		
		try {
			News news = newsService.queryNews(id);
			if(news!=null){
				list.add(news);
			}
			result = new Result<News>(200, "查询新闻成功！", list);
		} catch (Exception e) {
			result = new Result<News>(100, "查询新闻失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}

}
