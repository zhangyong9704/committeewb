package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shunan.committeewb.dao.NewsTypeMapper;
import com.shunan.committeewb.po.NewsType;
import com.shunan.committeewb.service.NewsTypeService;

@Service
@Transactional
public class NewsTypeServiceImpl implements NewsTypeService {
	@Autowired
	private NewsTypeMapper newsTypeMapper;

	/**
	 * 查询所有的新闻类别
	 */
	@Override
	public List<NewsType> queryAllNewsType() throws Exception {
		return newsTypeMapper.queryAllNewsType();
	}
}
