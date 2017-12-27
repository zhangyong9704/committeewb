package com.shunan.committeewb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	/**
	 * 查询一共多少条新闻 or 重点专注、公告通知等等
	 * @param typeID
	 * @param chooseStatus 
	 * @param search
	 * @return
	 * @throws Exception
	 */
	public long queryNewsTotal(String typeIDs, int chooseStatus,String search) throws Exception;

	/**
	 * 分页查询新闻 or 重点专注、公告通知等等
	 * @param typeID
	 * @param chooseStatus
	 * @param offset
	 * @param limit
	 * @param sort
	 * @param search
	 * @return
	 * @throws Exception
	 */
	public List<News> queryPageNews(String typeIDs, Integer chooseStatus, 
			Integer offset, Integer limit, String order,String search) throws Exception;

	/**
	 * 删除新闻
	 * @param typeIDs
	 * @throws Exception
	 */
	public void deleteNews(String ids) throws Exception;

	/**
	 * 添加新闻
	 * @param news
	 * @param picFile
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public int insertNews(News news, MultipartFile picFile, String account) throws Exception;
	
	/**
	 * 根据id查询新闻信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News queryNewsByID(int id) throws Exception;

	/**
	 * 编辑新闻
	 * @param news
	 * @param picFile
	 * @param account
	 * @throws Exception
	 */
	public void updateNews(News news, MultipartFile picFile,String account) throws Exception;

	/**
	 * 发布新闻
	 * @param news
	 * @param isRollImg 
	 * @throws Exception
	 */
	public void publishNews(News news, Integer isRollImg) throws Exception;

	/*****************
	 * 网站前端页面
	 *****************
	 */
	
	/**
	 * 新闻列表
	 * @param newsTypeID 新闻类型ID，图片新闻传0
	 * @param offset
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<? extends Object> newsList(String newsTypeID, int offset, int pageSize) throws Exception;
	
	/**
	 * 新闻列表中新闻总条数
	 * @param newsTypeID 新闻类型ID，图片新闻传0
	 * @return
	 * @throws Exception
	 */
	public long newsListTotal(String newsTypeID) throws Exception;

	/**
	 * 新闻列表中的当前位置
	 * @param newsTypeID
	 * @return
	 * @throws Exception
	 */
	public String newsListPosition(String newsTypeID) throws Exception;

	/**
	 * 上一篇、下一篇、首篇、尾篇
	 * @param newsTypeID
	 * @param id
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public News queryNews(Integer newsTypeID, Integer id, String type) throws Exception;
	
	/**
	 * 近期热门
	 * @return
	 * @throws Exception
	 */
	public List<News> queryHotNews() throws Exception;
}
