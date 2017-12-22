package com.shunan.committeewb.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.Home;
import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.po.Result;
import com.shunan.committeewb.service.HomeService;
import com.shunan.committeewb.service.NavService;
import com.shunan.committeewb.utils.CommonUtils;

/**
 * 规章制度、工作标准、通讯录、风采录
 * @author 李琳茹
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	@Autowired
	private NavService navService;
	
	/**
	 * 查询 规章制度、工作标准、通讯录、风采录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryHome/{id}")
	@ResponseBody
	public Result<Home> queryHome(@PathVariable("id") Integer id) throws Exception{
		Result<Home> result = null;
		List<Home> list = new ArrayList<Home>();
		
		try {
			Home home = homeService.queryHome(id);
			list.add(home);
			result = new Result<Home>(200, "查询成功！", list);
		} catch (Exception e) {
			result = new Result<Home>(100, "查询失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 修改规章制度、工作标准、通讯录、风采录
	 * @param home
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateHome/{id}")
	@ResponseBody
	public Result<Home> updateHome(Home home) throws Exception{
		Result<Home> result = null;
		List<Home> list = new ArrayList<Home>();
		
		//没有请求体时：用户直接copy url并打开一个新的页面，新页面请求数据，返回json数据
		if(home.getTitle()==null && home.getSource()==null && home.getContent()==null){
			try {
				Home returnHome = homeService.queryHome(home.getId());
				if(returnHome != null){
					list.add(returnHome);
					result = new Result<Home>(200, "查询成功！", list);
				}else{
					result = new Result<Home>(100, "查询的信息不存在！", list);
				}
			} catch (Exception e) {
				result = new Result<Home>(100, "查询失败！", list);
				e.printStackTrace();
			}
		}
		
		try {
			homeService.updateHome(home);
			Home returnHome = homeService.queryHome(home.getId());
			list.add(returnHome);
			result = new Result<Home>(200, "修改成功！", list);
		} catch (Exception e) {
			result = new Result<Home>(100, "修改失败！", list);
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 编辑规章制度等时，用户直接copy url并打开一个新的页面，返回前端该页面
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,Model model) throws Exception{
		Home home = homeService.queryHome(id);
		if(home == null){
			return "error/404";
		}
		model.addAttribute("id", id);
		model.addAttribute("type", home.getType());
		return "homeWrite";
	}
	
	/**
	 * to写规章制度等 页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/write")
	public String write() throws Exception{
		return "homeWrite";
	}
	
	/*****************
	 *网站前端页面
	 *****************
	 */
	/**
	 * 查询规章制度、工作标准、通讯录、风采录
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{id}/query")
	public String query(@PathVariable("id") Integer id,Model model) throws Exception{
		Home home = homeService.queryHome(id);
		model.addAttribute("home", home);
		
		List<Nav> navList = navService.queryAllNavs(); //导航栏
		model.addAttribute("navList", navList);
		
		String date = CommonUtils.dateFormate(new Date()); //日期
		String day = CommonUtils.getWeek(Calendar.getInstance());
		model.addAttribute("date", date);
		model.addAttribute("day", day);
		
		return "forward:/front/home.jsp";
	}

}
