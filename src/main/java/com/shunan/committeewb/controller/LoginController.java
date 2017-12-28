package com.shunan.committeewb.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shunan.committeewb.po.Banner;
import com.shunan.committeewb.po.LifeChat;
import com.shunan.committeewb.po.Nav;
import com.shunan.committeewb.po.News;
import com.shunan.committeewb.po.User;
import com.shunan.committeewb.service.BannerService;
import com.shunan.committeewb.service.LifeChatService;
import com.shunan.committeewb.service.NavService;
import com.shunan.committeewb.service.NewsService;
import com.shunan.committeewb.service.RollImgService;
import com.shunan.committeewb.service.UserService;
import com.shunan.committeewb.utils.CommonUtils;
import com.shunan.committeewb.utils.HttpClientHelper;

@Controller
public class LoginController {
	@Autowired
	private NavService navService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private RollImgService rollImgService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private LifeChatService lifeChatService;
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request,String randomCode) throws Exception{
		String validateCode = request.getSession().getAttribute("validateCode").toString();
		if(!(validateCode.toString().equalsIgnoreCase(randomCode))){
			request.setAttribute("msg", "验证码不正确！");
			return "redirect:/admin/login.jsp";
		}
		
		User u = userService.queryUserByAccount(user.getAccount());
		if(u == null){
			request.setAttribute("msg", "用户名/密码不正确！");
			return "redirect:/admin/login.jsp";
		}
		
		Md5Hash md5Hash = new Md5Hash(user.getPassword(), u.getSalt(), 10);
		String rePassword = md5Hash.toString();
		
		if(rePassword.equals(u.getPassword())){
			request.getSession().setAttribute("user", u);
			request.getSession().setMaxInactiveInterval(60*60*2);
			return "redirect:/admin/index.jsp";
		}else{
			request.setAttribute("msg", "用户名/密码不正确！");
			return "redirect:/admin/login.jsp";
		}
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception{

		request.getSession().removeAttribute("user");
		request.getSession().setMaxInactiveInterval(0);
		return "redirect:/admin/login.jsp";
	}
	
	@RequestMapping("/login2")
	public String login2(HttpServletRequest request) throws Exception{
		
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
	
/*	@RequestMapping("/index")
	public String index(HttpServletRequest request) throws Exception{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		request.getSession().setAttribute("user", user);
		return "index";
	}*/
	
	@RequestMapping("/index")
	public String home(Model model) throws Exception{
		List<Nav> navList = navService.queryAllNavs(); //导航栏
		String date = CommonUtils.dateFormate(new Date());
		String day = CommonUtils.getWeek(Calendar.getInstance());
		model.addAttribute("navList", navList);
		model.addAttribute("date", date);
		model.addAttribute("day", day);
		
		List<Banner> bannerList = bannerService.queryAllBanners(0); //头部大banner图
		List<Banner> linksList = bannerService.queryAllBanners(1); //底部友情链接
		model.addAttribute("bannerList", bannerList);
		model.addAttribute("linksList", linksList);
		
		List<News> rollImgList = rollImgService.queryHomeRollImg(); //轮播图
		model.addAttribute("rollImgList", rollImgList);
		
		//重点专注、公告栏、文件通知、团青快讯、蜀南青语、专题活动、青春剪影
		List<News> zdzzList = newsService.queryHomeNews(CommonUtils.NEWS_ZDZZ, CommonUtils.NEWS_ZDZZ_LIMIT);
		List<News> ggList = newsService.queryHomeNews(CommonUtils.NEWS_GG, CommonUtils.NEWS_GG_LIMIT);
		List<News> wjtzList = newsService.queryHomeNews(CommonUtils.NEWS_WJTZ, CommonUtils.NEWS_WJTZ_LIMIT);
		List<News> tqkxList = newsService.queryHomeNews(CommonUtils.NEWS_TQKX, CommonUtils.NEWS_TQKX_LIMIT);
		List<News> snqyList = newsService.queryHomeNews(CommonUtils.NEWS_SNQY, CommonUtils.NEWS_SNQY_LIMIT);
		List<News> zthdList = newsService.queryHomeNews(CommonUtils.NEWS_ZTHD, CommonUtils.NEWS_ZTHD_LIMIT);
		List<News> qcjyList = newsService.queryHomeNews(CommonUtils.NEWS_QCJY, CommonUtils.NEWS_QCJY_LIMIT);
		model.addAttribute("zdzzList", zdzzList);
		model.addAttribute("ggList", ggList);
		model.addAttribute("wjtzList", wjtzList);
		model.addAttribute("tqkxList", tqkxList);
		model.addAttribute("snqyList", snqyList);
		model.addAttribute("zthdList", zthdList);
		model.addAttribute("qcjyList", qcjyList);
		
		LifeChat lifeChat = lifeChatService.queryLifeChat(); //生活大家谈
		model.addAttribute("lifeChat", lifeChat);
		
		return "forward:/front/index4.jsp";
	}
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/code")
	public void getCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
	    int width = 110;// 定义图片的width
	    int height = 50;// 定义图片的height
	    int codeCount = 4;// 定义图片上显示验证码的个数
	    int xx = 20;
	    int fontHeight = 36;
	    int codeY = 36;
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
	            'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length-1)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", randomCode.toString());
        System.out.println("validateCode="+randomCode.toString());
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
	}
	
	/**
	 * 网站首页天气接口
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping(value="/weather",produces = "application/json;charset=utf-8")
	@RequestMapping("/weather")
	@ResponseBody
	public String weather() throws Exception{
		String url = "http://www.sojson.com/open/api/weather/json.shtml?city=%E6%B3%B8%E5%B7%9E";
		String weatherData = HttpClientHelper.sendGet(url, null, "utf-8");
		return weatherData;
	}
}
