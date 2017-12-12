package com.shunan.committeewb.dao;

import com.shunan.committeewb.po.Files;
import com.shunan.committeewb.po.NewsFile;

public interface FilesMapper {
	
	/**
	 * 添加附件
	 * @param files
	 * @throws Exception
	 */
	public void insertFiles(Files files) throws Exception;
	
	/**
	 * 添加新闻附件
	 * @param newsFile
	 * @throws Exception
	 */
	public void insertNewsfile(NewsFile newsFile) throws Exception;
}
