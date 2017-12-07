package com.shunan.committeewb.dao;

import java.util.List;

import com.shunan.committeewb.po.Banner;

public interface BannerMapper {
	/**
	 * 查询所有的头部大banner图 or 友情链接
	 * @return
	 * @throws Exception
	 */
	public List<Banner> queryAllBanners(int type) throws Exception;
	
	/**
	 * 添加banner图 or 友情链接
	 * @param banner
	 * @throws Exception
	 */
	public void insertBanner(Banner banner) throws Exception;
	
	/**
	 * 修改banner图 or 友情链接
	 * @param banner
	 * @throws Exception
	 */
	public void updateBanner(Banner banner) throws Exception;
	
	/**
	 * 根据id查询banner
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Banner queryBannerByID(int id) throws Exception;
	
	/**
	 * 删除banner
	 * @param id
	 * @throws Exception
	 */
	public void deleteBanner(int id) throws Exception;
	
}
