<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
    
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
    <h4>网站基本信息：</h4>
    logo:<img src="${pageContext.request.contextPath }/upload/${webInfo.logoUrl }"/><br/>
   	logo旁边的标题:<img src="${pageContext.request.contextPath }/upload/${webInfo.titleUrl }"/><br/>
   	网站背景图:<img src="${pageContext.request.contextPath }/upload/${webInfo.backgroundUrl }"/><br/>
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
    	图片：<img src="${pageContext.request.contextPath }/upload/${banner.picUrl}"/> </br>
    	跳转链接：${banner.jumpLink } <br/>
    	<hr/>
    </c:forEach>
    <br/><br/>
    
    <h4>友情链接：</h4>
    <c:forEach items="${linksList }" var="link">
    	标题：${link.name } </br>
    	图片：<img src="${pageContext.request.contextPath }/upload/${link.picUrl}"/> </br>
    	跳转链接：${link.jumpLink } <br/>
    	<hr/>
    </c:forEach>
    
    <h4>图片新闻：</h4>
    <table border="1px">
    <tr>
    	<th>标题</th>
    	<th>宣传图片</th>
    	<th>内容</th>
    	<th>发布时间</th>
    	<th>作者</th>
    </tr>
    <c:forEach items="${rollImgList }" var="news">
    	<tr>
    		<td>${news.title }</td>
   		<td>
   			<img src="${pageContext.request.contextPath }/upload/${news.picUrl}"/>
   		</td>
   		<td>${news.content }</td>
   		<td>
   			<fmt:formatDate value="${news.publishTime }" pattern="yyyy-MM-dd"/>
   		</td>
   		<td>${news.author }</td>
    	</tr>
    </c:forEach>
    </table>
    
    <h4>重点专注：</h4>
    <table border="1px">
    <tr>
    	<th>标题</th>
    	<th>宣传图片</th>
    	<th>内容</th>
    	<th>发布时间</th>
    	<th>作者</th>
    </tr>
    <c:forEach items="${zdzzList }" var="news">
   	<tr>
   		<td>${news.title }</td>
   		<td>
   			<img src="${pageContext.request.contextPath }/upload/${news.picUrl}"/>
   		</td>
   		<td>${news.content }</td>
   		<td>
   			<fmt:formatDate value="${news.publishTime }" pattern="yyyy-MM-dd"/>
   		</td>
   		<td>${news.author }</td>
   	</tr>
    </c:forEach>
    </table>
    <br/><br/>
    
    <h4>公告栏：</h4>
    <table border="1px">
    <tr>
    	<th>标题</th>
    	<th>宣传图片</th>
    	<th>内容</th>
    	<th>发布时间</th>
    	<th>作者</th>
    </tr>
    <c:forEach items="${ggList }" var="news">
   	<tr>
   		<td>${news.title }</td>
   		<td>
   			<img src="${pageContext.request.contextPath }/upload/${news.picUrl}"/>
   		</td>
   		<td>${news.content }</td>
   		<td>
   			<fmt:formatDate value="${news.publishTime }" pattern="yyyy-MM-dd"/>
   		</td>
   		<td>${news.author }</td>
   	</tr>
    </c:forEach>
    </table>
    <br/><br/>

  </body>
</html>
