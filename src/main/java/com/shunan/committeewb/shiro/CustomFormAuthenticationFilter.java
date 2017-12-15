package com.shunan.committeewb.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 自定义FormAuthenticationFilter，认证之前实现 验证码校验
 * @author 李琳茹
 *
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		//从session获取正确验证码
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session =httpServletRequest.getSession();
		String validateCode = (String) session.getAttribute("validateCode");
		
		//取出页面的验证码,输入的验证和session中的验证进行对比 
		String randomCode = httpServletRequest.getParameter("randomCode");
		System.out.println("session中validateCode="+validateCode+",用户输入randomCode="+randomCode);
		
		String username = httpServletRequest.getParameter("username");
		System.out.println("用户输入username="+username);
		
		if(randomCode!=null && validateCode!=null && !randomCode.equalsIgnoreCase(validateCode)){
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
			//拒绝访问，不再校验账号和密码 
			return true; 
		}
		return super.onAccessDenied(request, response);
	}
}
