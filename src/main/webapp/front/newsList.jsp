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
    
    <table border="1px">
    <tr>
    	<th>标题</th>
    	<th>宣传图片</th>
    	<th>内容</th>
    	<th>发布时间</th>
    	<th>作者</th>
    </tr>
    <c:forEach items="${newsList }" var="news">
   	<tr>
   		<td>${news.title }</td>
   		<td>
   			<img src="${pageContext.request.contextPath }/upload/${news.picUrl}" style="width:100px;height:100px;"/>
   		</td>
   		<td>${news.content }</td>
   		<td>
   			<fmt:formatDate value="${news.showTime }" pattern="yyyy-MM-dd"/>
   		</td>
   		<td>${news.author }</td>
   	</tr>
    </c:forEach>
    </table>
    
  </body>
</html>
