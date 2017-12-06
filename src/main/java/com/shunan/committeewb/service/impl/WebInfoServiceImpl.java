package com.shunan.committeewb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.dao.WebInfoMapper;
import com.shunan.committeewb.po.WebInfo;
import com.shunan.committeewb.service.WebInfoService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

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
	
	/**
	 * 根据网站id查询网站信息
	 */
	@Override
	public WebInfo queryWebInfoByID(int id) throws Exception {
		return webInfoMapper.queryWebInfoByID(id);
	}

	/**
	 * 修改网站信息
	 */
	@Override
	public void updateWebInfo(MultipartFile logoFile, MultipartFile titleFile, MultipartFile backgroundFile,
			WebInfo webInfo) throws Exception {
		if(logoFile!=null && logoFile.getOriginalFilename()!=null && (!logoFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(logoFile, webInfo, CommonUtils.WEBINFO_LOGO);
		}else{
			//未修改图片,仍用原图片
			WebInfo webInfo2 = webInfoMapper.queryWebInfoByID(webInfo.getId());
			if(webInfo2.getLogoUrl()!=null){
				webInfo.setLogoUrl(webInfo2.getLogoUrl());
			}
		}
		
		if(titleFile!=null && titleFile.getOriginalFilename()!=null && (!titleFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(titleFile, webInfo, CommonUtils.WEBINFO_TITLE);
		}else{
			WebInfo webInfo2 = webInfoMapper.queryWebInfoByID(webInfo.getId());
			if(webInfo2.getTitleUrl()!=null){
				webInfo.setTitleUrl(webInfo2.getTitleUrl());
			}
		}
		
		if(backgroundFile!=null && backgroundFile.getOriginalFilename()!=null && (!backgroundFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(backgroundFile, webInfo, CommonUtils.WEBINFO_BACKGROUND);
		}else{
			WebInfo webInfo2 = webInfoMapper.queryWebInfoByID(webInfo.getId());
			if(webInfo2.getBackgroundUrl()!=null){
				webInfo.setBackgroundUrl(webInfo2.getBackgroundUrl());
			}
		}
		
		webInfoMapper.updateWebInfo(webInfo);
	}
}
