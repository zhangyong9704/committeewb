package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.NavService;

/**
 * 导航栏
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/nav")
public class NavController {
	@Autowired
	private NavService navService;
	
	/**
	 * 查询所有的导航栏
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllNavs")
	@ResponseBody
	public Result<Nav> queryAllNavs() throws Exception{
		Result<Nav> result = null;
		List<Nav> list = new ArrayList<Nav>();
		try {
			list = navService.queryAllNavs();
			result = new Result<Nav>(200, "查询导航栏成功!", list);
		} catch (Exception e) {
			result = new Result<Nav>(100, "查询导航栏失败!", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 修改导航栏信息
	 * @param nav
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateNav")
	@ResponseBody
	public Result<String> updateNav(Nav nav) throws Exception{
		Result<String> result = null;
		List<String> list  =new ArrayList<String>();
		try {
			navService.updateNav(nav);
			result = new Result<String>(200, "修改导航栏信息成功!", list);
		} catch (Exception e) {
			result = new Result<String>(100, "修改导航栏信息失败!", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 添加导航栏信息
	 * @param nav
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertNav")
	@ResponseBody
	public Result<String> insertNav(Nav nav) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		try {
			navService.insertNav(nav);
			result = new Result<String>(200, "添加导航栏成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "添加导航栏失败！", list);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 删除导航栏信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteNav")
	@ResponseBody
	public Result<String> deleteNav(int id) throws Exception{
		Result<String> result = null;
		List<String> list = new ArrayList<String>();
		
		Nav nav2 = navService.queryNavByID(id);
		if(nav2 == null){
			return new Result<String>(100, "数据不存在,删除失败！", list);
		}
		
		try {
			navService.deleteNav(id);
			result = new Result<String>(200, "删除导航栏成功！", list);
		} catch (Exception e) {
			result = new Result<String>(100, "删除导航栏失败！", list);
			e.printStackTrace();
		}
		return result;
	}
}
