package com.shunan.committeewb.dao;

import java.util.List;
import com.shunan.committeewb.po.RollImg;

public interface RollImgMapper {
	/**
	 * 查询首页展示的轮播图的信息
	 * @return
	 * @throws Exception
	 */
	public List<RollImg> queryHomeRollImg() throws Exception;
}
