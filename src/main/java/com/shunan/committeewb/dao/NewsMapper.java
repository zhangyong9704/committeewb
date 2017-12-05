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
	public List<News> queryHomeNews(@Param("newsTypeID") int newsTypeID,@Param("limit") int limit) throws Exception;
}
