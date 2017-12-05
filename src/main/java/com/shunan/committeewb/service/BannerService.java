package com.shunan.committeewb.service;

import java.util.List;
import com.shunan.committeewb.po.Banner;

public interface BannerService {
	/**
	 * 查询所有的banner图
	 * @return
	 * @throws Exception
	 */
	public List<Banner> queryAllBanners() throws Exception;
}
