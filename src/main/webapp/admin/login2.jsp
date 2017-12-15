<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="${pageContext.request.contextPath }/admin/js/jquery-3.2.1.min.js"></script> 
	<script type="text/javascript">
    	$(function(){
        	//刷新验证码：重新给图片的src赋值，后边加时间，防止缓存 
    		$("#randomcode_img").click(function(){
    			$(this).attr('src',
                	'${pageContext.request.contextPath }/admin/validatecode.jsp?time=' + new Date().getTime());
    		});
    	});
	</script>

  </head>
  
  <body>
  <c:if test="${msg != null }">
  <strong>警告：</strong><font style="color:red">${msg }</font>
  </c:if>
     <form action="${pageContext.request.contextPath }/login" method="post">
    	username:<input type="text" name="username" placeholder="请输入您的用户名"/>
    	<br/>
    	password:<input type="password" name="password" placeholder="请输入您的密码"/>
    	<br/>
    	<input id="randomCode" name="randomCode" size="8" /> 
    	<img id="randomcode_img" src="${pageContext.request.contextPath }/admin/validatecode.jsp" alt=""
								width="56" height="20" align='absMiddle' /> 
		<br/>
    	<input type="reset" value="重置"/> &nbsp;&nbsp;<input type="submit" value="登录"/>
    </form>
  </body>
</html>
