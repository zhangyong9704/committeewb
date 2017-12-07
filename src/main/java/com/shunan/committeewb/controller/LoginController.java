package com.shunan.committeewb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.RollImg;
import com.shunan.committeewb.po.User;
import com.shunan.committeewb.po.WebInfo;
import com.shunan.committeewb.service.BannerService;
import com.shunan.committeewb.service.NavService;
import com.shunan.committeewb.service.NewsService;
import com.shunan.committeewb.service.RollImgService;
import com.shunan.committeewb.service.WebInfoService;
import com.shunan.committeewb.utils.CommonUtils;

@Controller
public class LoginController {
	@Autowired
	private WebInfoService webInfoService;
	@Autowired
	private NavService navService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private RollImgService rollImgService;
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception{
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName!=null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				request.setAttribute("msg", "用户不存在！");
			}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
				request.setAttribute("msg", "用户名/密码不正确！");
			}else if("randomCodeError".equals(exceptionClassName)){
				request.setAttribute("msg", "验证码不正确！");
			}
		}

		return "login";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) throws Exception{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		request.getSession().setAttribute("user", user);
		return "welcome";
	}
	
	@RequestMapping("/home")
	public String home(Model model) throws Exception{
		//网站基本信息
		WebInfo webInfo = webInfoService.queryWebInfo();
		//导航栏
		List<Nav> navList = navService.queryAllNavs();
		//头部大banner图
		List<Banner> bannerList = bannerService.queryAllBanners(0);
		//底部友情链接
		List<Banner> linksList = bannerService.queryAllBanners(1);
		//轮播图
		List<RollImg> rollImgList = rollImgService.queryHomeRollImg();
		//重点专注、公告栏、文件通知、团青快讯、蜀南青语、专题活动
		List<News> zdzzList = newsService.queryHomeNews(CommonUtils.NEWS_ZDZZ, CommonUtils.NEWS_ZDZZ_LIMIT);
		List<News> ggList = newsService.queryHomeNews(CommonUtils.NEWS_GG, CommonUtils.NEWS_GG_LIMIT);
		List<News> wjtzList = newsService.queryHomeNews(CommonUtils.NEWS_WJTZ, CommonUtils.NEWS_WJTZ_LIMIT);
		List<News> tqkxList = newsService.queryHomeNews(CommonUtils.NEWS_TQKX, CommonUtils.NEWS_TQKX_LIMIT);
		List<News> snqyList = newsService.queryHomeNews(CommonUtils.NEWS_SNQY, CommonUtils.NEWS_SNQY_LIMIT);
		List<News> zthdList = newsService.queryHomeNews(CommonUtils.NEWS_ZTHD, CommonUtils.NEWS_ZTHD_LIMIT);
		model.addAttribute("webInfo", webInfo);
		model.addAttribute("navList", navList);
		model.addAttribute("bannerList", bannerList);
		model.addAttribute("linksList", linksList);
		model.addAttribute("rollImgList", rollImgList);
		model.addAttribute("zdzzList", zdzzList);
		model.addAttribute("ggList", ggList);
		model.addAttribute("wjtzList", wjtzList);
		model.addAttribute("tqkxList", tqkxList);
		model.addAttribute("snqyList", snqyList);
		model.addAttribute("zthdList", zthdList);
		
		return "home";
	}
}
