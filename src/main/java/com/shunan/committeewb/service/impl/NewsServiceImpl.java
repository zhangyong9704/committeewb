package com.shunan.committeewb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.dao.NewsMapper;
import com.shunan.committeewb.dao.RollImgMapper;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.User;
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
		List<Integer> typeIDList = CommonUtils.transferStringToIntList(typeIDs);
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
		
		List<Integer> typeIDList = CommonUtils.transferStringToIntList(typeIDs);
		
		List<News> newsList = new ArrayList<News>();
		newsList = newsMapper.queryPageNews(typeIDList, chooseStatus, offset, limit, order);
		return newsList;
	}
	
	/**
	 * 删除新闻
	 */
	@Override
	public void deleteNews(String ids) throws Exception {
		List<Integer> idList = CommonUtils.transferStringToIntList(ids);
		rollImgMapper.deleteRollImg(idList);
		newsMapper.deleteNews(idList);
	}
	
	/**
	 * 添加新闻
	 */
	@Override
	public int insertNews(News news, MultipartFile picFile) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, news, CommonUtils.NEWS);
		}
/*		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		news.setAuthor(user.getAccount());*/
		news.setAuthor("admin"); //后续需要改成正在使用该系统的账号
		news.setCreateTime(new Date());
		newsMapper.insertNews(news);
		
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
	public void updateNews(News news, MultipartFile picFile) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, news, CommonUtils.NEWS);
		}
		newsMapper.updateNews(news);
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
		if(news2.getContent().contains("<img src=")){
			news.setIsHavePic(1); //图文
		}
		newsMapper.publishNews(news);
		
		//将新闻加入轮播图库
		if(isRollImg == 1){
			rollImgMapper.insertRollImg(new RollImg(news.getId()));
		}
	}
}
