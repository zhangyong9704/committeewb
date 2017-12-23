package com.shunan.committeewb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.RollImgList;

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
	
	/**
	 * 查询所有的轮播图
	 * @param rollImgList
	 * @return
	 * @throws Exception
	 */
	public List<RollImgList> queryAllRollImg() throws Exception;
	
	/**
	 * 修改轮播图
	 * @param rollImg
	 * @throws Exception
	 */
	public void updateRollImg(RollImg rollImg) throws Exception;
	
	/**
	 * 根据newsID查询轮播图 
	 * @param newsID
	 * @return
	 * @throws Exception
	 */
	public RollImg queryRollImgByNewsID(int newsID) throws Exception;
	
	/**
	 * 分页查询轮播图
	 * @param offset
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<RollImgList> queryPageRollImg(
			@Param("offset") int offset,@Param("pageSize") int pageSize) throws Exception;
	
	/**
	 * 查询一共有多少条轮播图
	 * @return
	 * @throws Exception
	 */
	public long queryRollImgTotal() throws Exception;
	
	/**
	 * 图片新闻详情中的 上一篇、下一篇、首篇、尾篇
	 * @param id
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public RollImg queryRollImgDetail(@Param("id") int id,
			@Param("type") String type) throws Exception;
}
