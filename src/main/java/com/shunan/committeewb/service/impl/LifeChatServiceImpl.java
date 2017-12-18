package com.shunan.committeewb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.dao.LifeChatMapper;
import com.shunan.committeewb.po.LifeChat;
import com.shunan.committeewb.service.LifeChatService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

@Service
@Transactional
public class LifeChatServiceImpl implements LifeChatService{
	
	@Autowired
	private LifeChatMapper lifeChatMapper;

	@Override
	public LifeChat queryLifeChat() throws Exception {
		return lifeChatMapper.queryLifeChat();
	}

	@Override
	public void updateLifeChat(LifeChat lifeChat, MultipartFile picFile) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, lifeChat, CommonUtils.SHDJT);
		}else{
			LifeChat lifeChat2 = lifeChatMapper.queryLifeChatByID(lifeChat.getId());
			if(lifeChat2.getPicUrl()!=null){
				lifeChat.setPicUrl(lifeChat2.getPicUrl());
			}
		}
		lifeChatMapper.updateLifeChat(lifeChat);
	}

}
