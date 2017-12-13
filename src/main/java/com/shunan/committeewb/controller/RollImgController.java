package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.Result;
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
}
