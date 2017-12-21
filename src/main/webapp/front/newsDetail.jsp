<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻详情页</title>
    
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
    <h4>新闻详情页</h4>
    标题：${news.title }
    <br/>
    时间：
    <fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
    <br/>
    内容：
    ${news.content }
    <hr/>
    
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
    
  </body>
</html>
