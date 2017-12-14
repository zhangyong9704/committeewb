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
  		field1、field2、field3、field4、field5<br/>
  	上传图片要求：<br/>
  	网站logo：1200*375  &nbsp;&nbsp;&nbsp; 首页title：1920*600 &nbsp;&nbsp;&nbsp; 首页背景图：1200*375
  	
  	
  	<h4>导航栏：</h4>
    http://20.14.3.19:8080/committeewb/nav/queryAllNavs <br>
    查询所有的导航栏
    <hr>
    http://20.14.3.19:8080/committeewb/nav/updateNav<br/>
    修改导航栏信息(参数:id(必要)、name、jumpLink、sort(显示顺序))
    <hr/>
    http://20.14.3.19:8080/committeewb/nav/insertNav<br/>
    添加导航信息(参数:name、jumpLink、sort(显示顺序))
   	<hr/>
   	http://20.14.3.19:8080/committeewb/nav/deleteNav<br/>
   	删除导航信息(参数:id(必要))
   	
   	
   	<h4>banner图：</h4>
   	http://20.14.3.19:8080/committeewb/banner/queryAllBanners<br/>
   	查询所有的banner图(参数：type=0)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/insertBanner<br/>
   	添加banner图<br/>
   	参数：name、picFile(上传的文件)、jumpLink、type=0<br/>
   	上传图片要求：1190*370
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/updateBanner<br/>
   	修改banner图<br/>
   	参数：id、name、picFile(上传的文件)、jumpLink<br/>
   	上传图片要求：1190*370
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/deleteBanner<br/>
   	删除banner图<br/>
   	参数：id
   	
   	
   	<h4>友情链接：</h4>
   	http://20.14.3.19:8080/committeewb/banner/queryAllBanners<br/>
   	查询所有的友情链接(参数：type=1)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/insertBanner<br/>
   	添加友情链接<br/>
   	参数：name、picFile(上传的文件)、jumpLink、type=1<br/>
   	上传图片要求：110*30
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/updateBanner<br/>
   	修改友情链接<br/>
   	参数：id、name、picFile(上传的文件)、jumpLink<br/>
   	上传图片要求：110*30
   	<hr/>
   	http://20.14.3.19:8080/committeewb/banner/deleteBanner<br/>
   	删除友情链接<br/>
   	参数：id
   	
   	<h4>新闻类别：</h4>
   	http://20.14.3.19:8080/committeewb/newsType/queryAllNewsType<br/>
   	查询所有的新闻类别
   	
   	<h4>新闻：</h4>
   	http://20.14.3.19:8080/committeewb/news/queryPageNews<br/>
   	查询所有的新闻  or 重点专注、文件通知等<br/>
   	参数：typeIDs(新闻类别，CheckBox的name值，前端可选>=0个的新闻类别进行查询)、
   			chooseStatus(选择查看的新闻的状态：0所有状态的新闻、1已发布、2定时发布、3草稿)、<br/>
   	&nbsp;&nbsp;&nbsp;offset(偏移量)、limit(每页显示的记录数)、order(显示顺序)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/news/deleteNews<br/>
   	删除新闻<br/>
   	参数：ids(新闻ID，CheckBox的name值)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/news/write<br/>
   	to写文章页面 <br/>
   	<hr/>
   	http://20.14.3.19:8080/committeewb/news/draft(id:RESTful风格)<br/>
   	添加新闻 <br/>
   	参数：id(第一次向后台发送请求时，id=-1;以后再发送请求时，id=News的id)、修改的字段（新闻宣传图片picFile）
   	<hr/>
   	http://20.14.3.19:8080/committeewb/news/edit(RESTful风格)<br/>
   	编辑新闻时，用户直接copy url并打开一个新的页面，返回前端该页面 <br/>
   	参数：id(新闻的id)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/news/publishNews<br/>
   	发布新闻<br/>
   	参数：newsTypeID(新闻类别id)、showTime(显示时间,可为null)、isRollImg(是否加入轮播图库：0否,1是)
   	<hr/>
   	
   	<h4>轮播图：</h4>
   	http://20.14.3.19:8080/committeewb/rollImg/queryAllRollImg<br/>
   	查询所有的轮播图<br/>
   	<hr/>
   	http://20.14.3.19:8080/committeewb/rollImg/deleteRollImg<br/>
   	删除轮播图<br/>
   	参数：newsIDs(新闻ID，CheckBox的name值)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/rollImg/updateRollImg<br/>
   	修改轮播图<br/>
   	参数：newsID(必要,新闻ID)、sort(必要,显示顺序)、isShow(必要,是否在首页展示:0不展示,1展示)
   	<hr/>
   	
   	<h4>规章制度、工作标准、通讯录、风采录：</h4>
   	http://20.14.3.19:8080/committeewb/home/queryHome(RESTful风格)<br/>
   	查询规章制度、工作标准、通讯录、风采录<br/>
   	参数：id(规章制度-->风采录，依次为1、2、3、4)
   	<hr/>
   	http://20.14.3.19:8080/committeewb/home/updateHome(id:RESTful风格)<br/>
   	修改规章制度、工作标准、通讯录、风采录<br/>
   	参数：id(规章制度-->风采录，依次为1、2、3、4)、修改的字段
   	<hr/>
   	http://20.14.3.19:8080/committeewb/home/write<br/>
   	to写规章制度等页面 (homeWrite.jsp) <br/>
   	<hr/>
   	http://20.14.3.19:8080/committeewb/home/edit(RESTful风格)<br/>
   	编辑规章制度时，用户直接copy url并打开一个新的页面，返回前端该页面 <br/>
   	参数：id(规章制度等的id)(规章制度-->风采录，依次为1、2、3、4)
   	<hr/>
  </body>
</html>
