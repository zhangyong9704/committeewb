package com.shunan.committeewb.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.NewsType;
import com.shunan.committeewb.po.PageResult;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.po.User;
import com.shunan.committeewb.service.BannerService;
import com.shunan.committeewb.service.NavService;
import com.shunan.committeewb.service.NewsService;
import com.shunan.committeewb.service.NewsTypeService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.CreateFileUtil;
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
	@Autowired
	private NavService navService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private NewsTypeService newsTypeService;
	
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
			Integer offset,Integer limit,String order,String search) throws Exception{
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		long count = 0;
		
		if(chooseStatus == null){
			return new Result<News>(100, "参数不合法！", list);
		}
		
		try {
			list = newsService.queryPageNews(typeIDs,chooseStatus,offset,limit,order,search);
			count = newsService.queryNewsTotal(typeIDs,chooseStatus,search);
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
	public Result<? extends Object> insertNews(News news,
			MultipartFile picFile,HttpServletRequest request) throws Exception{
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
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
		}
		
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
		
		User user = (User) request.getSession().getAttribute("user");
		//有请求体时2种情况
		if(news.getId()==-1){
			//添加新闻
			try {
				int newsID = newsService.insertNews(news,picFile,user.getAccount());
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
				newsService.updateNews(news,picFile,user.getAccount());
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
	 * 查询水印照片配置
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryWatermark")
	@ResponseBody
	public Result<Object> queryWatermark() throws Exception{
		Result<Object> result = null;
		List<Object> list = new ArrayList<Object>();
		
		try {
			File baseFile = new File(Test.class.getClassLoader().getResource("/").getPath());
			File parentFile  = baseFile.getParentFile().getParentFile();
			String filePath = parentFile.getAbsolutePath()+File.separator;
			String jsonFilePath = filePath+"admin/jsp/config.json";
			
			InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(jsonFilePath)),"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String str = null,jsonStr = "";
			while((str=br.readLine())!=null){
				System.out.println("str===>"+str);
				jsonStr += str;
			}
			br.close();
			
			JSONObject jsonObject = new JSONObject(jsonStr);
			boolean isWatermark = jsonObject.getBoolean("isWatermark");
			String watermarkText = jsonObject.getString("watermarkText");
			String watermarkImgPath = jsonObject.getString("watermarkImgPath");
			String watermarkType = jsonObject.getString("watermarkType");
			list.add(isWatermark);
			list.add(watermarkText);
			list.add(watermarkImgPath);
			list.add(watermarkType);
			result = new Result<Object>(200, "查询成功！", list);
		} catch (Exception e) {
			result = new Result<Object>(100, "查询失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 修改水印照片配置
	 * @param request
	 * @param picFile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/watermark")
	@ResponseBody
	public Result<String> watermark(HttpServletRequest request,MultipartFile picFile) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		File baseFile = new File(Test.class.getClassLoader().getResource("/").getPath());
		File parentFile  = baseFile.getParentFile().getParentFile();
		String filePath = parentFile.getAbsolutePath()+File.separator;
		System.out.println("filePath-->"+filePath);
		String watermarkImgPath = "";
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(picFile,
					CommonUtils.WATERMARK_WIDTH, CommonUtils.WATERMARK_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
			//上传的照片大小以及像素均符合要求，则上传该水印照片至服务器
			String originalFilename = picFile.getOriginalFilename();
			if(originalFilename.contains(".")){
				String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				String picFilePath = filePath+"watermark/";
				System.out.println("picFilePath-->"+picFilePath);
				File file=new File(picFilePath+newFileName);
				if(CreateFileUtil.createFile(picFilePath+newFileName)){
					picFile.transferTo(file);
					watermarkImgPath = "/watermark/"+newFileName;
				}
			}
		}
		
		try {
			String jsonFilePath = filePath+"admin/jsp/config.json";
			InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(jsonFilePath)),"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String str = null,jsonStr = "";
			
			while((str=br.readLine())!=null){
				System.out.println("str===>"+str);
				jsonStr += str;
			}
			br.close();
			
			JSONObject jsonObject = new JSONObject(jsonStr);
			String isWatermark = request.getParameter("isWatermark");
			String watermarkText = request.getParameter("watermarkText");
			String watermarkType = request.getParameter("watermarkType");
			
			if(isWatermark!=null && (!isWatermark.equals(""))){
				jsonObject.put("isWatermark", Boolean.parseBoolean(isWatermark));
			}
			if(watermarkText!=null && (!watermarkText.equals(""))){
				jsonObject.put("watermarkText", watermarkText);
			}
			if(watermarkImgPath!=null && (!watermarkImgPath.equals(""))){
				jsonObject.put("watermarkImgPath", watermarkImgPath);
			}
			if(watermarkType!=null && (!watermarkType.equals(""))){
				jsonObject.put("watermarkType", watermarkType);
			}
			
			jsonStr = jsonObject.toString();
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File(jsonFilePath)),"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(jsonStr);
			bw.flush();
			bw.close();
			
			result = new Result<String>(200, "修改配置成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改配置失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/****************
	 * 网站前端页面
	 ****************
	 */
	
	/**
	 * 新闻列表
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("newsList")
	public String newsList(HttpServletRequest request,Model model) throws Exception{
		//右侧新闻列表所需数据
		int currentPage = 1;
		int pageSize = 20;
		String newsTypeID = request.getParameter("newsTypeID");
		if(request.getParameter("currentPage")!=null && (!request.getParameter("currentPage").equals(""))){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int offset = (currentPage-1)*pageSize;
		
		List<? extends Object> newsList = newsService.newsList(newsTypeID, offset, pageSize);
		long rowCount = newsService.newsListTotal(newsTypeID);
		int pageCount = (int) ((rowCount-1)/pageSize + 1);
		
		model.addAttribute("newsList", newsList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("rowCount", rowCount);
		
		List<Nav> navList = navService.queryAllNavs(); //导航栏
		List<Banner> bannerList = bannerService.queryAllBanners(0); //头部大banner图
		model.addAttribute("navList", navList);
		model.addAttribute("bannerList", bannerList);
		
		String date = CommonUtils.dateFormate(new Date()); //日期
		String day = CommonUtils.getWeek(Calendar.getInstance());
		model.addAttribute("date", date);
		model.addAttribute("day", day);
		
		String newsTypeName = newsService.newsListPosition(newsTypeID); //当前位置
		model.addAttribute("newsTypeName", newsTypeName);
		model.addAttribute("newsTypeID", newsTypeID);
		
		List<NewsType> newsTypeList = new ArrayList<NewsType>(); //新闻类别
		NewsType newsType = new NewsType(0, "图片新闻");
		newsTypeList.add(newsType);
		newsTypeList.addAll(newsTypeService.queryAllNewsType());
		model.addAttribute("newsTypeList", newsTypeList);
		
		return "forward:/front/listpage.jsp";
	}
	
	/**
	 * 查询新闻详情，访问量+1
	 * @param newsTypeID
	 * @param id
	 * @param type
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{newsTypeID}/{id}/query")
	public String query(@PathVariable("newsTypeID") int newsTypeID,
			@PathVariable("id") int id,Model model) throws Exception{
		News news = newsService.queryNews(newsTypeID,id,"eq"); //当前新闻
		model.addAttribute("news", news);
		model.addAttribute("newsTypeID", newsTypeID);
		
		News firstNews = newsService.queryNews(newsTypeID, id, "first");//首篇、上一篇、下一篇、尾篇
		News previousNews = newsService.queryNews(newsTypeID, id, "previous"); 
		News nextNews = newsService.queryNews(newsTypeID, id, "next");
		News lastNews = newsService.queryNews(newsTypeID, id, "last");
		model.addAttribute("firstNews", firstNews);
		model.addAttribute("previousNews", previousNews);
		model.addAttribute("nextNews", nextNews);
		model.addAttribute("lastNews", lastNews);
		
		List<Nav> navList = navService.queryAllNavs(); //导航栏
		model.addAttribute("navList", navList);
		
		String date = CommonUtils.dateFormate(new Date()); //日期
		String day = CommonUtils.getWeek(Calendar.getInstance());
		model.addAttribute("date", date);
		model.addAttribute("day", day);
		
		List<News> hotNewsList = newsService.queryHotNews(); //近期热门
		model.addAttribute("hotNewsList", hotNewsList);
		
		return "forward:/front/details.jsp";
	}
}
