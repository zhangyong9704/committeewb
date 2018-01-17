package com.shunan.committeewb.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Activity;
import com.shunan.committeewb.po.News;

public interface ActivityService {
	/**
	 * 查询所有的专题活动
	 * @return
	 * @throws Exception
	 */
	public List<Activity> queryAllActivity() throws Exception;

	/**
	 * 添加专题标签
	 * @param picFile
	 * @param activity
	 * @throws Exception
	 */
	public void insertActivity(MultipartFile picFile, Activity activity) throws Exception;

	/**
	 * 修改专题标签
	 * @param picFile
	 * @param activity
	 * @throws Exception
	 */
	public void updateActivity(MultipartFile picFile, Activity activity) throws Exception;
	/**
	 * 根据id查询专题标签
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Activity queryActivityByID(int id) throws Exception;
	/**
	 * 删除activity
	 * @param ids
	 * @throws Exception
	 */
	public void deleteActivity(String ids) throws Exception;
	/**
	 * 查询升序排序的前10条专题标签
	 * @return
	 * @throws Exception
	 */
	public List<Activity> queryLimitActivity() throws Exception;
	/**
	 * 根据newsID查询其拥有的activityID
	 * @param newsID
	 * @return
	 * @throws Exception
	 */
	public List<Integer> selectActivityIDByNewsID(Integer newsID) throws Exception;
	
	/**
	 * 查询专题标签下的新闻
	 * @param activityID
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<News> selectNewsByActivityID(Integer activityID,Integer offset,Integer limit) throws Exception;
	
	/**
	 * 查询专题标签下的新闻条数
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	public Long selectNewsByActivityIDTotal(Integer activityID) throws Exception;
	
	/**
	 * 查找新闻的特定标签
	 * @param newsID
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	public int selectNewsSpecialActivity(Integer newsID,Integer activityID) throws Exception;
	
	/**
	 * 删除新闻的特定标签
	 * @param newsIDs
	 * @param activityID
	 * @throws Exception
	 */
	public void deleteNewsSpecialActivity(String newsIDs,Integer activityID) throws Exception;
}
