package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.dao.BannerMapper;
import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.service.BannerService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public List<Banner> queryAllBanners(int type) throws Exception {
		return bannerMapper.queryAllBanners(type);
	}
	
	@Override
	public void insertBanner(MultipartFile picFile, Banner banner) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, banner, CommonUtils.HOME_BANNER);
		}
		bannerMapper.insertBanner(banner);
	}

	@Override
	public void updateBanner(MultipartFile picFile, Banner banner) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, banner, CommonUtils.HOME_BANNER);
		}else{
			//未修改图片,仍用原图片
			Banner banner2 = bannerMapper.queryBannerByID(banner.getId());
			if(banner2.getPicUrl()!=null){
				banner.setPicUrl(banner2.getPicUrl());
			}
		}
		
		bannerMapper.updateBanner(banner);
	}

	@Override
	public void deleteBanner(int id) throws Exception {
		bannerMapper.deleteBanner(id);
	}

	@Override
	public Banner queryBannerByID(int id) throws Exception {
		return bannerMapper.queryBannerByID(id);
	}

}
