package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.RollImgMapper;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.RollImgList;
import com.shunan.committeewb.service.RollImgService;

@Service
@Transactional
public class RollImgServiceImpl implements RollImgService{
	@Autowired
	private RollImgMapper rollImgMapper;

	/**
	 * 查询首页展示的轮播图的信息
	 */
	@Override
	public List<RollImg> queryHomeRollImg() throws Exception {
		return rollImgMapper.queryHomeRollImg();
	}

	@Override
	public List<RollImgList> queryAllRollImg() throws Exception {
		return rollImgMapper.queryAllRollImg();
	}
}
