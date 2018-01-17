package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shunan.committeewb.po.Activity;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.PageResult;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.ActivityService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.FileUtil;

/**
 * 专题标签
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/activity/")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 查询所有的专题标签
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryAllActivity")
	@ResponseBody
	public Result<Activity> queryAllActivity() throws Exception{
		Result<Activity> result = null;
		List<Activity> list = new ArrayList<Activity>();
		
		try {
			list = activityService.queryAllActivity();
			result = new Result<Activity>(200, "查询专题标签成功！", list);
		} catch (Exception e) {
			result = new Result<Activity>(100, "查询专题标签失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 添加专题标签
	 * @param picFile
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("insertActivity")
	@ResponseBody
	public Result<String> insertActivity(MultipartFile picFile,Activity activity) throws Exception{
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(picFile, 
					CommonUtils.ZTHD_WIDTH, CommonUtils.ZTHD_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		//添加
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		try {
			activityService.insertActivity(picFile,activity);
			result = new Result<String>(200, "添加专题标签成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "添加专题标签失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 修改专题标签
	 * @param picFile
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateActivity")
	@ResponseBody
	public Result<String> updateActivity(MultipartFile picFile,Activity activity) throws Exception{
		if(picFile!=null && picFile.getOriginalFilename()!=null && (!picFile.getOriginalFilename().equals(""))){
			Result<String> picResult = FileUtil.checkFile(picFile, 
					CommonUtils.ZTHD_WIDTH, CommonUtils.ZTHD_HEIGHT, CommonUtils.FILE_MAXSIZE);
			if(picResult.getCode()!=200){
				return picResult;
			}
		}
		//修改
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		try {
			activityService.updateActivity(picFile,activity);
			result = new Result<String>(200, "修改专题标签成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改专题标签失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除专题标签
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteActivity")
	@ResponseBody
	public Result<String> deleteActivity(String ids) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		if(ids==null || ids.equals("")){
			return new Result<String>(100, "请先选择要删除的新闻标签！", list);
		}
		
		try {
			activityService.deleteActivity(ids);
			result = new Result<String>(200, "删除新闻成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除新闻失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 查询专题标签下的新闻
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectNewsByActivityID")
	@ResponseBody
	public Result<News> selectNewsByActivityID(@RequestParam(value="activityID") Integer activityID,
			@RequestParam(value="offset",defaultValue="0") Integer offset,@RequestParam(value="limit",defaultValue="10") Integer limit) throws Exception{
		Result<News> result = null;
		List<News> list = new ArrayList<News>();
		long count = 0;
		
		if(activityID == null){
			return new Result<News>(100, "参数不合法！请传递专题标签id！", list);
		}
		
		try {
			list = activityService.selectNewsByActivityID(activityID,offset,limit);
			count = activityService.selectNewsByActivityIDTotal(activityID);
			result = new PageResult<News>(200, "查询成功！", list, count);
		} catch (Exception e) {
			result = new PageResult<News>(100, "查询失败！", list, count);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 删除新闻的特定标签
	 * @param newsID
	 * @param activityID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteNewsSpecialActivity")
	@ResponseBody
	public Result<String> deleteNewsSpecialActivity(String newsIDs, Integer activityID) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		if(newsIDs==null || activityID==null){
			return new Result<String>(100, "参数不合法！请传递新闻id和专题标签id！", list);
		}
		
		try {
			activityService.deleteNewsSpecialActivity(newsIDs, activityID);
			result = new Result<String>(200, "删除成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
}
