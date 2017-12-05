package com.shunan.committeewb.dao;

import java.util.List;

import com.shunan.committeewb.po.Banner;

public interface BannerMapper {
	/**
	 * 查询所有的banner图
	 * @return
	 * @throws Exception
	 */
	public List<Banner> queryAllBanners() throws Exception;
}
