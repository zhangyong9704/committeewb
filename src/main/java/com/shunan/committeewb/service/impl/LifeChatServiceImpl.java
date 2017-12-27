package com.shunan.committeewb.service.impl;

import java.io.File;

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
		LifeChat lifeChat2 = lifeChatMapper.queryLifeChatByID(lifeChat.getId());
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			File file = new File(FileUtil.getUploadPath()+lifeChat2.getPicUrl());
			if(file.exists()){
				file.delete();
			}
			FileUtil.uploadFile(picFile, lifeChat, CommonUtils.SHDJT);
		}else{
			if(lifeChat2.getPicUrl()!=null){
				lifeChat.setPicUrl(lifeChat2.getPicUrl());
			}
		}
		
		lifeChatMapper.updateLifeChat(lifeChat);
		lifeChat2 = null;
	}

}
