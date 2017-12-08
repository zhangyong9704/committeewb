<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/news/queryPageNews" method="post">
    	新闻类别:
    	<input type="checkbox" value="1" name="typeID"/>重点专注
		&nbsp;&nbsp;
    	<input type="checkbox" value="2" name="typeID"/>公告
    	&nbsp;&nbsp;
    	<input type="checkbox" value="3" name="typeID"/>文件通知
    	&nbsp;&nbsp;
    	<input type="checkbox" value="4" name="typeID"/>团青快讯
    	&nbsp;&nbsp;
    	<input type="checkbox" value="5" name="typeID"/>蜀南青语
    	&nbsp;&nbsp;
    	<input type="checkbox" value="6" name="typeID"/>专题活动
    	<br/>
    	新闻状态：
    	<select name="chooseStatus">
    		<option value="0">所有状态</option>
    		<option value="1">已发布</option>
    		<option value="2">定时发布</option>
    		<option value="3">草稿</option>
    	</select>
    	<br/>
    	当前页：<input type="text" name="currentPage"/>
    	<br/>
    	每页记录条数：<input type="text" name="pageSize"/>
    	<br/>
    	显示顺序：
    	<select name="sort">
    		<option value="0">升序</option>
    		<option value="1">降序</option>
    	</select>
    	<br/>
    	<input type="submit" value="查询"/>
    </form>
  </body>
</html>
