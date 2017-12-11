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
    	<input type="checkbox" value="1" name="typeIDs"/>重点专注
		&nbsp;&nbsp;
    	<input type="checkbox" value="2" name="typeIDs"/>公告
    	&nbsp;&nbsp;
    	<input type="checkbox" value="3" name="typeIDs"/>文件通知
    	&nbsp;&nbsp;
    	<input type="checkbox" value="4" name="typeIDs"/>团青快讯
    	&nbsp;&nbsp;
    	<input type="checkbox" value="5" name="typeIDs"/>蜀南青语
    	&nbsp;&nbsp;
    	<input type="checkbox" value="6" name="typeIDs"/>专题活动
    	<br/>
    	新闻状态：
    	<select name="chooseStatus">
    		<option value="0">所有状态</option>
    		<option value="1">已发布</option>
    		<option value="2">定时发布</option>
    		<option value="3">草稿</option>
    	</select>
    	<br/>
    	偏移量：<input type="text" name="offset" value="1"/>
    	<br/>
    	每页记录条数：<input type="text" name="limit"/>
    	<br/>
    	显示顺序：
    	<select name="sort">
    		<option value="asc">升序</option>
    		<option value="desc">降序</option>
    	</select>
    	<br/>
    	<input type="submit" value="查询"/>
    </form>
  </body>
</html>
