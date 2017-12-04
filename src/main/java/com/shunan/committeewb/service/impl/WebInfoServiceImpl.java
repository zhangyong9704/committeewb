package com.shunan.committeewb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.WebInfoMapper;
import com.shunan.committeewb.po.WebInfo;
import com.shunan.committeewb.service.WebInfoService;

/**
 * 网站基本信息Service层
 * @author 李琳茹
 *
 */
@Service
@Transactional
public class WebInfoServiceImpl implements WebInfoService {
	
	@Autowired
	private WebInfoMapper webInfoMapper;

	/**
	 * 查询网站基本信息
	 */
	@Override
	public WebInfo queryWebInfo() throws Exception {
		return webInfoMapper.queryWebInfo();
	}

}
