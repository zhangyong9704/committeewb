package com.shunan.committeewb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shunan.committeewb.po.News;

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
	public List<News> queryPageNews(@Param("typeIDs") String typeIDs,@Param("chooseStatus") int chooseStatus,
			@Param("begin") int begin,@Param("pageSize") int pageSize,@Param("sort") int sort) throws Exception;
	
	/**
	 * 查询一共多少条新闻
	 * @return
	 * @throws Exception
	 */
	public Long queryNewsTotal(@Param("typeIDs") String typeIDs,
			@Param("chooseStatus") int chooseStatus) throws Exception;
}
