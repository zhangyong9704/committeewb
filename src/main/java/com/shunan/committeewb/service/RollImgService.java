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
}
