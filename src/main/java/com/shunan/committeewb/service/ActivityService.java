package com.shunan.committeewb.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.shunan.committeewb.po.Activity;

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
}
