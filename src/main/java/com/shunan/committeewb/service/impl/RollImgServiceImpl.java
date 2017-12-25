package com.shunan.committeewb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shunan.committeewb.dao.RollImgMapper;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.RollImgList;
import com.shunan.committeewb.service.RollImgService;
import com.shunan.committeewb.utils.CommonUtils;

@Service
@Transactional
public class RollImgServiceImpl implements RollImgService{
	@Autowired
	private RollImgMapper rollImgMapper;

	/**
	 * 查询首页展示的轮播图的信息
	 */
	@Override
	public List<News> queryHomeRollImg() throws Exception {
		return rollImgMapper.queryHomeRollImg();
	}

	@Override
	public List<RollImgList> queryAllRollImg() throws Exception {
		return rollImgMapper.queryAllRollImg();
	}

	/**
	 * 删除轮播图
	 */
	@Override
	public void deleteRollImg(String newsIDs) throws Exception {
		List<Integer> newsIDList = CommonUtils.transferStringToIntList(newsIDs);
		rollImgMapper.deleteRollImg(newsIDList);
	}

	/**
	 * 修改轮播图
	 */
	@Override
	public void updateRollImg(RollImg rollImg) throws Exception {
		rollImgMapper.updateRollImg(rollImg);
	}

	/**
	 * 根据newsID查询rollImg
	 */
	@Override
	public RollImg queryRollImgByNewsID(Integer newsID) throws Exception {
		return rollImgMapper.queryRollImgByNewsID(newsID);
	}
}
