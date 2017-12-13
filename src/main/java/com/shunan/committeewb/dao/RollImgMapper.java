package com.shunan.committeewb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.shunan.committeewb.po.RollImg;

public interface RollImgMapper {
	/**
	 * 查询首页展示的轮播图的信息
	 * @return
	 * @throws Exception
	 */
	public List<RollImg> queryHomeRollImg() throws Exception;
	
	/**
	 * 删除轮播图
	 * @param newsIDList
	 * @throws Exception
	 */
	public void deleteRollImg(@Param("newsIDList") List<Integer> newsIDList) throws Exception;
	
	/**
	 * 添加轮播图
	 * @param rollImg
	 * @throws Exception
	 */
	public void insertRollImg(RollImg rollImg) throws Exception;
}
