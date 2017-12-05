package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.RollImg;

public interface RollImgService {
	/**
	 * 查询首页展示的轮播图的信息
	 * @return
	 * @throws Exception
	 */
	public List<RollImg> queryHomeRollImg() throws Exception;
}
