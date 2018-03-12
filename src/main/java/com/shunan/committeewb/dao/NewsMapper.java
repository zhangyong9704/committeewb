package com.shunan.committeewb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.PortalNewsVO;

public interface NewsMapper {
	/**
	 * 查询首页需要展示的重点专注、文件通知、团青快讯等
	 * @param newsTypeID
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<News> queryHomeNews(@Param("newsTypeID") int newsTypeID,
			@Param("limit") int limit) throws Exception;
	
	/**
	 * 分页查询所有的新闻
	 * @param begin
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<News> queryPageNews(@Param("typeIDList") List<Integer> typeIDList,@Param("chooseStatus") int chooseStatus,
			@Param("offset") int offset,@Param("limit") int limit,@Param("order") String order,@Param("search") String search) throws Exception;
	
	/**
	 * 查询一共多少条新闻
	 * @return
	 * @throws Exception
	 */
	public Long queryNewsTotal(@Param("typeIDList") List<Integer> typeIDList,
			@Param("chooseStatus") int chooseStatus,@Param("search") String search) throws Exception;
	
	/**
	 * 删除新闻
	 * @param idList
	 * @throws Exception
	 */
	public void deleteNews(@Param("idList") List<Integer> idList) throws Exception;
	
	/**
	 * 插入新闻
	 * @param news
	 * @throws Exception
	 */
	public void insertNews(News news) throws Exception;
	
	/**
	 * 修改新闻
	 * @param news
	 * @throws Exception
	 */
	public void updateNews(News news) throws Exception;
	
	/**
	 * 发布新闻
	 * @param news
	 * @throws Exception
	 */
	public void publishNews(News news) throws Exception;
	
	/**
	 * 根据id查询新闻信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News queryNewsByID(int id) throws Exception;
	
	/**
	 * 增加新闻的访问量
	 * @param id
	 * @throws Exception
	 */
	public void updateNewsCount(int id) throws Exception;
	
	/**
	 * 新闻详情
	 * @param newsTypeID
	 * @param id
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public News queryNewsDetail(@Param("newsTypeID") int newsTypeID,
			@Param("id") int id,@Param("type") String type) throws Exception;
	
	/**
	 * 近期热门
	 * @return
	 * @throws Exception
	 */
	public List<News> queryHotNews() throws Exception;
	
	/**
	 * 改变新闻 是否是 热门新闻 这一状态
	 * @param id
	 * @param isHotNews
	 * @throws Exception
	 */
	public void changeHotNewsStatus(@Param("id") Integer id,
			@Param("isHotNews") Integer isHotNews) throws Exception;
	
	/**
	 * 门户网站 分页查询重点关注、文件通知等
	 * @return
	 * @throws Exception
	 */
	public List<PortalNewsVO> portalPageNews(@Param("newsTypeID") Integer newsTypeID,
			@Param("offset") Integer offset,@Param("limit") Integer limit) throws Exception;
}
