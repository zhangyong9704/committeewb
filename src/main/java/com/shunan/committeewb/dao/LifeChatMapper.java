package com.shunan.committeewb.dao;

import com.shunan.committeewb.po.LifeChat;

/**
 * 生活大家谈
 * @author 李琳茹
 *
 */
public interface LifeChatMapper {
	
	/**
	 * 查询 生活大家谈
	 * @return
	 * @throws Exception
	 */
	public LifeChat queryLifeChat() throws Exception;
	
	/**
	 * 修改 生活大家谈
	 * @param lifeChat
	 * @throws Exception
	 */
	public void updateLifeChat(LifeChat lifeChat) throws Exception;
	
	/**
	 * 根据id查询生活大家谈
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LifeChat queryLifeChatByID(int id) throws Exception;
}
