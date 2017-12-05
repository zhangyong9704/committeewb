package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shunan.committeewb.dao.BannerMapper;
import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.service.BannerService;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public List<Banner> queryAllBanners() throws Exception {
		return bannerMapper.queryAllBanners();
	}

}
