<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>接口</title>
    
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
  	<h4>网站设置：</h4>
  	http://20.14.3.19:8080/committeewb/webInfo/queryWebInfo<br/>
  	查询网站设置信息
  	<hr/>
  	http://20.14.3.19:8080/committeewb/webInfo/updateWebInfo<br/>
  	修改网站设置信息<br/>
  	参数:id(必要)、logoFile(网站logo,可选项)、titleFile(网站标题,可选项)、backgroundFile(网站背景图,可选项)、
  		field1、field2、field3、field4、field5
  	
  	
  	<h4>导航栏：</h4>
    http://20.14.3.19:8080/committeewb/nav/queryAllNavs <br>
    查询所有的导航栏
    <hr>
    http://20.14.3.19:8080/committeewb/nav/updateNav<br/>
    修改导航栏信息(参数:id(必要)、name、jumpLink)
    <hr/>
    http://20.14.3.19:8080/committeewb/nav/insertNav<br/>
    添加导航信息(参数:name、jumpLink)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/nav/deleteNav<br/>
   	删除导航信息(参数:id(必要))
   	
   	<h4>banner图：</h4>
   	
   	<h4>友情链接：</h4>
  </body>
</html>
