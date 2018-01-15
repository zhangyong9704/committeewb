package com.shunan.committeewb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shunan.committeewb.po.Activity;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.NewsActivity;
import com.shunan.committeewb.po.PortalNewsVO;

public interface ActivityMapper {
	/**
	 * 查询所有的专题标签
	 * @return
	 * @throws Exception
	 */
	public List<Activity> queryAllActivity() throws Exception;
	/**
	 * 添加专题标签-
	 * @param activity
	 * @throws Exception
	 */
	public void insertActivity(Activity activity) throws Exception;
	/**
	 * 修改专题标签
	 * @param activity
	 * @throws Exception
	 */
	public void updateActivity(Activity activity) throws Exception;
	/**
	 * 根据id查询专题标签
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Activity queryActivityByID(int id) throws Exception;
	/**
	 * 删除activity
	 * @param id
	 * @throws Exception
	 */
	public void deleteActivity(@Param("idList") List<Integer> idList) throws Exception;
	
	/**
	 * 添加NewsActivity
	 * @param newsActivity
	 * @throws Exception
	 */
	public void insertNewsActivity(NewsActivity newsActivity) throws Exception;
	
	/**
	 * 根据activityID删除newsActivity
	 * @param ids
	 * @throws Exception
	 */
	public void deleteNewsActivityByActivityID(@Param("idList") List<Integer> idList) throws Exception;
	
	/**
	 * 根据NewsID删除newsActivity
	 * @param ids
	 * @throws Exception
	 */
	public void deleteNewsActivityByNewsID(@Param("idList") List<Integer> idList) throws Exception;
	
	/**
	 * 根据activityID查询新闻列表
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	public List<News> newsActivityList(@Param("activityID") Integer activityID) throws Exception;
	
	/**
	 * 查询升序排序的前10条专题标签
	 * @return
	 * @throws Exception
	 */
	public List<Activity> queryLimitActivity() throws Exception;
	
	/**
	 * 分页查询专题活动列表
	 * @param activityID
	 * @param offset
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	public List<PortalNewsVO> portalNewsActivityList(@Param("activityID") Integer activityID,
			@Param("offset") Integer offset,@Param("limit") Integer limit) throws Exception;
	
	/**
	 * 专题活动列表 总条数
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	public Long portalNewsActivityListTotal(@Param("activityID") Integer activityID) throws Exception;
}
