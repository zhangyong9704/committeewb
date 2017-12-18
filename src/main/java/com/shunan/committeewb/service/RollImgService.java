package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.RollImgList;

public interface RollImgService {
	/**
	 * 查询首页展示的轮播图的信息
	 * @return
	 * @throws Exception
	 */
	public List<RollImg> queryHomeRollImg() throws Exception;
	
	/**
	 * 查询所有的轮播图
	 * @param rollImgList
	 * @return
	 * @throws Exception
	 */
	public List<RollImgList> queryAllRollImg() throws Exception;

	/**
	 * 删除轮播图
	 * @param newsIDs
	 * @throws Exception
	 */
	public void deleteRollImg(String newsIDs) throws Exception;

	/**
	 * 修改轮播图
	 * @param rollImg
	 * @throws Exception
	 */
	public void updateRollImg(RollImg rollImg) throws Exception;

	/**
	 * 根据newsID查询rollImg
	 * @param newsID
	 * @return
	 * @throws Exception
	 */
	public RollImg queryRollImgByNewsID(Integer newsID) throws Exception;
}
