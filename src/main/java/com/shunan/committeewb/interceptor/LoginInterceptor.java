package com.shunan.committeewb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * 后台管理系统，必须先登录才可以进入系统，若未登录，则直接跳转至登录页面
 * 前台宣传页面，无需登录，可浏览宣传信息
 * @author 李琳茹
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("/committeewb/admin/login.jsp");
			return false;
		}
		return true;
	}
}
