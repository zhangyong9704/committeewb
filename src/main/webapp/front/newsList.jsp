<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻列表</title>
    
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
    共${pageCount }页，共${rowCount }条数据
    <br/>
    
    <h4>标题：</h4>
    <c:forEach items="${newsList }" var="news">
    	<a href="${pageContext.request.contextPath }/news/${news.id }/queryNews">${news.title }</a>>
    	<br/>
    </c:forEach>
    
    <h4>网站基本信息：</h4>
    logo:<img src="${pageContext.request.contextPath }/upload/${webInfo.logoUrl }" style="width:100px;height:100px;"/><br/>
   	logo旁边的标题:<img src="${pageContext.request.contextPath }/upload/${webInfo.titleUrl }" style="width:100px;height:100px;"/><br/>
   	网站背景图:<img src="${pageContext.request.contextPath }/upload/${webInfo.backgroundUrl }" style="width:100px;height:100px;"/><br/>
   	底部字段:${webInfo.field1 },${webInfo.field2 },${webInfo.field3 },${webInfo.field4 },${webInfo.field5 }<br/><br/>
    
    <h4>导航栏信息：</h4>
    <table border="1px">
    <tr>
    	<th>标题名称</th>
    	<th>跳转链接</th>
    </tr>
    <c:forEach items="${navList }" var="nav">
    <tr>
    	<td>${nav.name }</td>
    	<td>${nav.jumpLink }</td>
    </tr>
   	</c:forEach>
    </table>
    <br/><br/>
    
    <h4>banner图：</h4>
    <c:forEach items="${bannerList }" var="banner">
    	标题：${banner.name } </br>
    	图片：<img src="${pageContext.request.contextPath }/upload/${banner.picUrl}" style="width:100px;height:100px;"/> </br>
    	跳转链接：${banner.jumpLink } <br/>
    	<hr/>
    </c:forEach>
    <br/><br/>
    
  </body>
</html>
