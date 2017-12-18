package com.shunan.committeewb.service;

import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.LifeChat;

public interface LifeChatService {
	/**
	 * 查询 生活大家谈
	 * @return
	 * @throws Exception
	 */
	public LifeChat queryLifeChat() throws Exception;

	/**
	 * 修改生活大家谈
	 * @param lifeChat
	 * @param picFile
	 * @throws Exception
	 */
	public void updateLifeChat(LifeChat lifeChat, MultipartFile picFile) throws Exception;
	
}
