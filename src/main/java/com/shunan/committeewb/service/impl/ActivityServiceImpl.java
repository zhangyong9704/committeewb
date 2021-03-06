package com.shunan.committeewb.service.impl;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.dao.ActivityMapper;
import com.shunan.committeewb.po.Activity;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.service.ActivityService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	private ActivityMapper activityMapper;

	/**
	 * 查询所有的专题标签
	 */
	@Override
	public List<Activity> queryAllActivity() throws Exception {
		return activityMapper.queryAllActivity();
	}

	/**
	 * 添加专题标签
	 */
	@Override
	public void insertActivity(MultipartFile picFile, Activity activity) throws Exception {
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			FileUtil.uploadFile(picFile, activity, CommonUtils.ACTIVITY);
		}
		activityMapper.insertActivity(activity);
	}

	/**
	 * 修改专题标签
	 */
	@Override
	public void updateActivity(MultipartFile picFile, Activity activity) throws Exception {
		Activity activity2 = activityMapper.queryActivityByID(activity.getId());
		
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			File file = new File(FileUtil.getUploadPath()+activity2.getUrl());
			if(file.exists()){
				file.delete();
			}
			FileUtil.uploadFile(picFile, activity, CommonUtils.ACTIVITY);
		}else{
			//未修改图片,仍用原图片
			if(activity2.getUrl()!=null){
				activity.setUrl(activity2.getUrl());
			}
		}
		
		activityMapper.updateActivity(activity);
		activity2 = null;
	}

	/**
	 * 根据ID查询专题标签
	 */
	@Override
	public Activity queryActivityByID(int id) throws Exception {
		return activityMapper.queryActivityByID(id);
	}

	/**
	 * 删除专题标签
	 */
	@Override
	public void deleteActivity(String ids) throws Exception {
		List<Integer> idList = CommonUtils.transferStringToIntList(ids);
		
		//删除专题标签的宣传图片
		for(int id:idList){
			Activity activity = activityMapper.queryActivityByID(id);
			if(activity!=null){
				File file = new File(FileUtil.getUploadPath()+activity.getUrl());
				if(file.exists()){
					file.delete();
				}
			}
		}
		
		activityMapper.deleteActivity(idList);
		activityMapper.deleteNewsActivityByActivityID(idList);
	}

	/**
	 * 查询升序排序的前10条专题标签
	 */
	@Override
	public List<Activity> queryLimitActivity() throws Exception {
		return activityMapper.queryLimitActivity();
	}

	/**
	 * 根据newsID查询其拥有的activityID
	 */
	@Override
	public List<Integer> selectActivityIDByNewsID(Integer newsID) throws Exception {
		return activityMapper.selectActivityIDByNewsID(newsID);
	}

	/**
	 * 查询专题标签下的所有新闻
	 */
	@Override
	public List<News> selectNewsByActivityID(Integer activityID,Integer offset,Integer limit) throws Exception {
		return activityMapper.selectNewsByActivityID(activityID,offset,limit);
	}

	/**
	 * 删除新闻的特定标签
	 */
	@Override
	public void deleteNewsSpecialActivity(String newsIDs, Integer activityID) throws Exception {
		List<Integer> newsIDList = CommonUtils.transferStringToIntList(newsIDs);
		activityMapper.deleteNewsSpecialActivity(newsIDList, activityID);
	}

	/**
	 * 查找新闻的特定标签
	 */
	@Override
	public int selectNewsSpecialActivity(Integer newsID, Integer activityID) throws Exception {
		return activityMapper.selectNewsSpecialActivity(newsID, activityID);
	}

	/**
	 * 查询专题标签下的新闻条数
	 */
	@Override
	public Long selectNewsByActivityIDTotal(Integer activityID) throws Exception {
		return activityMapper.selectNewsByActivityIDTotal(activityID);
	}
	
}
