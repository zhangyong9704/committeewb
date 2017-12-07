package com.shunan.committeewb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Banner;

public interface BannerService {
	/**
	 * 查询所有的头部大banner图 or 友情链接
	 * @return
	 * @throws Exception
	 */
	public List<Banner> queryAllBanners(int type) throws Exception;
	
	/**
	 * 添加banner图 or 友情链接
	 * @param picFile 
	 * @param banner
	 * @throws Exception
	 */
	public void insertBanner(MultipartFile picFile, Banner banner) throws Exception;
	
	/**
	 * 修改banner图 or 友情链接
	 * @param banner
	 * @throws Exception
	 */
	public void updateBanner(MultipartFile picFile,Banner banner) throws Exception;
	
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
