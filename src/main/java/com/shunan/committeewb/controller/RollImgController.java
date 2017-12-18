package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.RollImgList;
import com.shunan.committeewb.service.RollImgService;

/**
 * 轮播图
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/rollImg")
public class RollImgController {
	
	@Autowired
	private RollImgService rollImgService;
	
	/**
	 * 查询所有的轮播图
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllRollImg")
	@ResponseBody
	public Result<RollImgList> queryAllRollImg() throws Exception{
		Result<RollImgList> result = null;
		List<RollImgList> list = new ArrayList<RollImgList>();
		
		try {
			list = rollImgService.queryAllRollImg();
			result = new Result<RollImgList>(200, "查询轮播图成功！", list);
		} catch (Exception e) {
			result = new Result<RollImgList>(100, "查询轮播图失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 删除轮播图
	 * @param newsIDs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteRollImg")
	@ResponseBody
	public Result<String> deleteRollImg(String newsIDs) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		if(newsIDs==null || newsIDs.equals("")){
			return new Result<String>(100, "请先选择要删除的轮播图！", list);
		}
		
		try {
			rollImgService.deleteRollImg(newsIDs);
			result = new Result<String>(200, "删除轮播图成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除轮播图失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 修改轮播图
	 * @param rollImg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateRollImg")
	@ResponseBody
	public Result<String> updateRollImg(RollImg rollImg) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		try {
			rollImgService.updateRollImg(rollImg);
			result = new Result<String>(200, "修改轮播图成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改轮播图失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 根据newsID查询rollImg
	 * @param newsID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryRollImgByNewsID/{newsID}")
	@ResponseBody
	public Result<RollImg> queryRollImgByNewsID(@PathVariable("newsID") Integer newsID) throws Exception{
		Result<RollImg> result = null;
		List<RollImg> list = new ArrayList<RollImg>();
		
		try {
			RollImg rollImg = rollImgService.queryRollImgByNewsID(newsID);
			if(rollImg != null){
				list.add(rollImg);
			}
			result = new Result<RollImg>(200, "查询成功！", list);
		} catch (Exception e) {
			result = new Result<RollImg>(100, "查询失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
}
