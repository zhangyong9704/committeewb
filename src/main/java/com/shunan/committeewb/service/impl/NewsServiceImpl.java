package com.shunan.committeewb.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.dao.ActivityMapper;
import com.shunan.committeewb.dao.NewsMapper;
import com.shunan.committeewb.dao.NewsTypeMapper;
import com.shunan.committeewb.dao.RollImgMapper;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.NewsActivity;
import com.shunan.committeewb.po.NewsType;
import com.shunan.committeewb.po.PortalNewsVO;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.service.NewsService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper; 
	@Autowired
	private RollImgMapper rollImgMapper;
	@Autowired
	private NewsTypeMapper newsTypeMapper;
	@Autowired
	private ActivityMapper activityMapper;

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
	public long queryNewsTotal(String typeIDs, int chooseStatus,String search) throws Exception {
		long count = 0;
		List<Integer> typeIDList = CommonUtils.transferStringToIntList(typeIDs);
		count = newsMapper.queryNewsTotal(typeIDList, chooseStatus,search);
		return count;
	}

	/**
	 * 分页查询所有的新闻 or 重点专注、公告通知等等
	 */
	@Override
	public List<News> queryPageNews(String typeIDs, Integer chooseStatus, 
			Integer offset, Integer limit, String order,String search) throws Exception {
		if(offset == null){
			offset = 0;
		}
		if(limit == null){
			limit = 10;
		}
		if(order == null){
			order = "asc";
		}
		
		List<Integer> typeIDList = CommonUtils.transferStringToIntList(typeIDs);
		
		List<News> newsList = new ArrayList<News>();
		newsList = newsMapper.queryPageNews(typeIDList, chooseStatus, offset, limit, order,search);
		return newsList;
	}
	
	/**
	 * 删除新闻
	 */
	@Override
	public void deleteNews(String ids) throws Exception {
		List<Integer> idList = CommonUtils.transferStringToIntList(ids);
		
		//删除新闻的宣传图片
		for(int id:idList){
			News news = newsMapper.queryNewsByID(id);
			if(news!=null){
				File file = new File(FileUtil.getUploadPath()+news.getPicUrl());
				if(file.exists()){
					file.delete();
				}
			}
		}
		
		activityMapper.deleteNewsActivityByNewsID(idList);
		rollImgMapper.deleteRollImg(idList);
		newsMapper.deleteNews(idList);
	}
	
	/**
	 * 添加新闻
	 */
	@Override
	public int insertNews(News news, MultipartFile picFile,String account,String activities) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, news, CommonUtils.NEWS);
		}
/*		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		news.setAuthor(user.getAccount());*/
		news.setAuthor(account); 
		news.setCreateTime(new Date());
		newsMapper.insertNews(news);
		
		//添加至新闻专题表
		if(activities!=null && !("".equals(activities))){
			List<Integer> activityIDList = CommonUtils.transferStringToIntList(activities);
			for(int activityID:activityIDList){
				NewsActivity newsActivity = new NewsActivity(news.getId(), activityID);
				activityMapper.insertNewsActivity(newsActivity);
			}
		}
		
/*		if(attachmentFiles!=null){
			for(MultipartFile attachmentFile:attachmentFiles){
				if(attachmentFile!=null && attachmentFile.getOriginalFilename()!=null && (!attachmentFile.getOriginalFilename().equals(""))){
					String filePath = FileUtil.getUploadFilePath()+"attachment"+"/";
					String yearMonth = FileUtil.getYearMonth();
					String originalFilename = attachmentFile.getOriginalFilename();
					
					if(originalFilename.contains(".")){
						String newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
						//新文件
						File file=new File(filePath+newFileName);
						String dbUploadFileName = yearMonth+"/attachment/"+newFileName;
						if(CreateFileUtil.createFile(filePath+newFileName)){
							//将内存中的文件写入硬盘
							picFile.transferTo(file);
							
							//添加该附件至数据库
							Files f = new Files();
							f.setName(originalFilename);
							f.setUrl(dbUploadFileName);
							filesMapper.insertFiles(f);
							
							//添加至新闻附件表
							NewsFile newsFile = new NewsFile();
							newsFile.setNewsID(news.getId());
							newsFile.setFileID(f.getId());
							filesMapper.insertNewsfile(newsFile);
						}
					}
				}
			}
		}*/
		
		return news.getId();
	}

	@Override
	public News queryNewsByID(int id) throws Exception {
		return newsMapper.queryNewsByID(id);
	}

	/**
	 * 编辑新闻
	 */
	@Override
	public void updateNews(News news, MultipartFile picFile,String account,String activities) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			//删除旧宣传图片并上传新宣传图片
			News news2 = newsMapper.queryNewsByID(news.getId());
			File file = new File(FileUtil.getUploadPath()+news2.getPicUrl());
			if(file.exists()){
				file.delete();
			}	
			FileUtil.uploadFile(picFile, news, CommonUtils.NEWS);
		}
		news.setAuthor(account);
		newsMapper.updateNews(news);
		
		//修改新闻时，若将新闻类型修改为了"生活大家谈"、"青春剪影"，且该新闻存在轮播图表中，则删除之
		int newsTypeID = news.getNewsTypeID();
		if(newsTypeID==8 || newsTypeID==7){
			RollImg rollImg = rollImgMapper.queryRollImgByNewsID(news.getId());
			if(rollImg!=null){
				List<Integer> newsIDList = new ArrayList<Integer>();
				newsIDList.add(news.getId());
				rollImgMapper.deleteRollImg(newsIDList);
			}
		}
		
		//修改新闻的专题标签
		if(activities!=null && !("".equals(activities))){
			List<Integer> newsIDList = new ArrayList<Integer>();
			newsIDList.add(news.getId());
			activityMapper.deleteNewsActivityByNewsID(newsIDList);
			
			List<Integer> activityIDList = CommonUtils.transferStringToIntList(activities);
			for(int activityID:activityIDList){
				NewsActivity newsActivity = new NewsActivity(news.getId(), activityID);
				activityMapper.insertNewsActivity(newsActivity);
			}
		}
	}

	/**
	 * 发布新闻
	 */
	@Override
	public void publishNews(News news,Integer isRollImg) throws Exception {
		//发布新闻
		if(news.getShowTime()==null){
			news.setShowTime(new Date());
		}
		News news2 = newsMapper.queryNewsByID(news.getId());
		if(news2.getContent()!=null){
			if(news2.getContent().contains("<img src=")){
				news.setIsHavePic(1); //图文
			}
		}
		newsMapper.publishNews(news);
		
		//若轮播图库中存在该新闻，则删除之
		RollImg rollImg = rollImgMapper.queryRollImgByNewsID(news.getId());
		if(rollImg != null){
			List<Integer> newsIDList = new ArrayList<Integer>();
			newsIDList.add(rollImg.getNewsID());
			rollImgMapper.deleteRollImg(newsIDList);
		}
		
		//判断是否将新闻加入轮播图库
		if(isRollImg == 1){
			rollImgMapper.insertRollImg(new RollImg(news.getId()));
		}
	}

	/************
	 * 网站前端
	 ************
	 */

	/**
	 * 新闻列表
	 */
	@Override
	public List<PortalNewsVO> newsList(String newsTypeID, int offset, int pageSize,String activityID) throws Exception {
		List<PortalNewsVO> portalNewsVOList = new ArrayList<PortalNewsVO>(); 
		
		if(newsTypeID.equals("0")){
			//图片新闻
			portalNewsVOList = rollImgMapper.queryPageRollImg(offset, pageSize);
		}else if(newsTypeID.equals("6")){
			//专题活动
			portalNewsVOList = activityMapper.portalNewsActivityList(Integer.parseInt(activityID), offset, pageSize);
		}else{
			//重点关注、文件通知等
			portalNewsVOList = newsMapper.portalPageNews(Integer.parseInt(newsTypeID), offset, pageSize);
		}
		return portalNewsVOList;
	}

	/**
	 * 新闻列表中新闻总条数
	 */
	@Override
	public long newsListTotal(String newsTypeID,String activityID) throws Exception {
		long rowCount = 0;
		if(newsTypeID.equals("0")){
			//图片新闻
			rowCount = rollImgMapper.queryRollImgTotal();
		}else if(newsTypeID.equals("6")){
			//专题活动
			rowCount = activityMapper.portalNewsActivityListTotal(Integer.parseInt(activityID));
		}else{
			//重点关注、文件通知等
			rowCount = this.queryNewsTotal(newsTypeID, 1,"");
		}
		return rowCount;
	}

	/**
	 * 新闻列表中的当前位置
	 */
	@Override
	public String newsListPosition(String newsTypeID) throws Exception {
		String newsTypeName = "";
		int typeID = Integer.parseInt(newsTypeID);
		if(typeID == 0){
			newsTypeName = "图片新闻";
		}else if(newsTypeID.equals("6")){
			//专题活动
			newsTypeName = "专题活动";
		}else{
			NewsType newsType = newsTypeMapper.queryNewsTypeByID(typeID);
			newsTypeName = newsType.getName();
		}
		return newsTypeName;
	}

	/**
	 *  新闻详情
	 */
	@Override
	public News queryNews(Integer activityID,Integer newsTypeID, Integer id, String type) throws Exception {
		News news = null;
		if(newsTypeID==0){
			//图片新闻
			RollImg rollImg = rollImgMapper.queryRollImgDetail(id, type);
			if(rollImg != null){
				news = newsMapper.queryNewsByID(rollImg.getNewsID());
			}
		}else if(newsTypeID==6){
			//专题活动
			Integer newsID = activityMapper.queryNewsActivityDetail(activityID,id, type);
			if(newsID != null){
				news = newsMapper.queryNewsByID(newsID);
			}
		}else{
			//重点关注、文件通知等等
			news = newsMapper.queryNewsDetail(newsTypeID, id, type);
		}
		
		//已发布，且当前时间>新闻显示时间
		if(news!=null && "eq".equals(type) && news.getStatus()==0){
			if(System.currentTimeMillis()-news.getShowTime().getTime()>0){
				newsMapper.updateNewsCount(news.getId());
			}
		}
		return news;
	}

	@Override
	public List<News> queryHotNews() throws Exception {
		return newsMapper.queryHotNews();
	}
}
