package com.shunan.committeewb.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shunan.committeewb.po.User;

@Controller
public class LoginController {
	
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
	public String home() throws Exception{
		
		return "home";
	}
}
