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

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script><script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-8" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp">
  	<%
		Object user = request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("/committeewb/admin/login.jsp");
		}
	 %>
  	<h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-8" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-7" data-genuitec-path="/committeewb/src/main/webapp/admin/interf.jsp">后台管理系统接口</h1>
  	 <h4>登录</h4>
     http://20.14.3.21:8080/committeewb/login<br/>
     登录<br/>
     参数：username、password、randomCode（验证码）<br/>
     验证码图片来源：${pageContext.request.contextPath }/admin/validatecode.jsp
     <hr/>
     
  	<h4>网站设置：</h4>
  	http://20.14.3.21:8080/committeewb/webInfo/queryWebInfo<br/>
  	查询网站设置信息
  	<hr/>
  	http://20.14.3.21:8080/committeewb/webInfo/updateWebInfo<br/>
  	修改网站设置信息<br/>
  	参数:id(必要)、logoFile(网站logo,可选项)、titleFile(网站标题,可选项)、backgroundFile(网站背景图,可选项)、
  		field1、field2、field3、field4、field5<br/>
  	上传图片要求：<br/>
  	网站logo：1200*375  &nbsp;&nbsp;&nbsp; 首页title：1920*600 &nbsp;&nbsp;&nbsp; 首页背景图：1200*375
  	
  	
  	<h4>导航栏：</h4>
    http://20.14.3.21:8080/committeewb/nav/queryAllNavs <br>
    查询所有的导航栏
    <hr>
    http://20.14.3.21:8080/committeewb/nav/updateNav<br/>
    修改导航栏信息(参数:id(必要)、name、jumpLink、sort(显示顺序))
    <hr/>
    http://20.14.3.21:8080/committeewb/nav/insertNav<br/>
    添加导航信息(参数:name、jumpLink、sort(显示顺序))
   	<hr/>
   	http://20.14.3.21:8080/committeewb/nav/deleteNav<br/>
   	删除导航信息(参数:id(必要))
   	
   	
   	<h4>banner图：</h4>
   	http://20.14.3.21:8080/committeewb/banner/queryAllBanners<br/>
   	查询所有的banner图(参数：type=0)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/insertBanner<br/>
   	添加banner图<br/>
   	参数：name、picFile(上传的文件)、jumpLink、type=0<br/>
   	上传图片要求：1190*370
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/updateBanner<br/>
   	修改banner图<br/>
   	参数：id、name、picFile(上传的文件)、jumpLink<br/>
   	上传图片要求：1190*370
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/deleteBanner<br/>
   	删除banner图<br/>
   	参数：id
   	
   	
   	<h4>友情链接：</h4>
   	http://20.14.3.21:8080/committeewb/banner/queryAllBanners<br/>
   	查询所有的友情链接(参数：type=1)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/insertBanner<br/>
   	添加友情链接<br/>
   	参数：name、picFile(上传的文件)、jumpLink、type=1<br/>
   	上传图片要求：110*30
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/updateBanner<br/>
   	修改友情链接<br/>
   	参数：id、name、picFile(上传的文件)、jumpLink<br/>
   	上传图片要求：110*30
   	<hr/>
   	http://20.14.3.21:8080/committeewb/banner/deleteBanner<br/>
   	删除友情链接<br/>
   	参数：id
   	
   	<h4>新闻类别：</h4>
   	http://20.14.3.21:8080/committeewb/newsType/queryAllNewsType<br/>
   	查询所有的新闻类别
   	
   	<h4>新闻：</h4>
   	http://20.14.3.21:8080/committeewb/news/queryPageNews<br/>
   	查询所有的新闻  or 重点专注、文件通知等<br/>
   	参数：typeIDs(新闻类别，CheckBox的name值，前端可选>=0个的新闻类别进行查询)、
   			chooseStatus(选择查看的新闻的状态：0所有状态的新闻、1已发布、2定时发布、3草稿)、<br/>
   	&nbsp;&nbsp;&nbsp;offset(偏移量)、limit(每页显示的记录数)、order(显示顺序：asc、desc)、search（搜索）
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/deleteNews<br/>
   	删除新闻<br/>
   	参数：ids(新闻ID，CheckBox的name值)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/write<br/>
   	to写文章页面 <br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/draft(id:RESTful风格)<br/>
   	添加新闻 <br/>
   	参数：id(第一次向后台发送请求时，id=-1;以后再发送请求时，id=News的id)、修改的字段（新闻宣传图片picFile）、activities(专题标签ID、CheckBox的id值)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/edit(RESTful风格)<br/>
   	编辑新闻时，用户直接copy url并打开一个新的页面，返回前端该页面 <br/>
   	参数：id(新闻的id)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/publishNews<br/>
   	发布新闻<br/>
   	参数：newsTypeID(新闻类别id)、showTime(显示时间,可为null)、isRollImg(是否加入轮播图库：0否,1是)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/queryWatermark<br/>
   	查询水印照片配置<br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/watermark<br/>
   	修改水印照片配置<br/>
   	参数：isWatermark、watermarkText、watermarkType、picFile（图片水印）
   	<hr/>
   	
   	<h4>轮播图：</h4>
   	http://20.14.3.21:8080/committeewb/rollImg/queryAllRollImg<br/>
   	查询所有的轮播图<br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/rollImg/deleteRollImg<br/>
   	删除轮播图<br/>
   	参数：newsIDs(新闻ID，CheckBox的id值)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/rollImg/updateRollImg<br/>
   	修改轮播图<br/>
   	参数：newsID(必要,新闻ID)、sort(必要,显示顺序)、isShow(必要,是否在首页展示:0不展示,1展示)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/rollImg/queryRollImgByNewsID(RESTful风格)<br/>
   	根据newsID查询rollImg<br/>
   	参数：newsID(必要,新闻ID)
   	<hr/>
   	
   	<h4>规章制度、工作标准、通讯录、风采录：</h4>
   	http://20.14.3.21:8080/committeewb/home/queryHome(RESTful风格)<br/>
   	查询规章制度、工作标准、通讯录、风采录<br/>
   	参数：id(规章制度-->风采录，依次为1、2、3、4)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/home/updateHome(id:RESTful风格)<br/>
   	修改规章制度、工作标准、通讯录、风采录<br/>
   	参数：id(规章制度-->风采录，依次为1、2、3、4)、修改的字段
   	<hr/>
   	http://20.14.3.21:8080/committeewb/home/write<br/>
   	to写规章制度等页面 (homeWrite.jsp) <br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/home/edit(RESTful风格)<br/>
   	编辑规章制度时，用户直接copy url并打开一个新的页面，返回前端该页面 <br/>
   	参数：id(规章制度等的id)(规章制度-->风采录，依次为1、2、3、4)
   	<hr/>
   	
   	<h4>生活大家谈</h4>
   	http://20.14.3.21:8080/committeewb/lifeChat/queryLifeChat<br/>
   	查询 生活大家谈<br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/lifeChat/updateLifeChat<br/>
   	修改 生活大家谈<br/>
   	参数：id、name、picFile(上传的图片在表单中的name值)
   	<hr/>
   	
   	<h4>专题标签</h4>
   	http://20.14.3.21:8080/committeewb/activity/queryAllActivity<br/>
   	查询 所有的专题标签<br/>
   	<hr/>
   	http://20.14.3.21:8080/committeewb/activity/insertActivity<br/>
   	添加 专题标签<br/>
   	参数：id、name、picFile(上传的图片在表单中的name值)、sort(显示顺序)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/activity/updateActivity<br/>
   	修改 专题标签<br/>
   	参数：id、name、picFile(上传的图片在表单中的name值)、sort(显示顺序)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/activity/deleteActivity<br/>
   	删除 专题标签<br/>
   	参数：ids(专题标签ID，CheckBox的id值)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/activity/selectNewsByActivityID<br/>
   	查询专题标签下的新闻<br/>
   	参数：activityID(专题标签ID)、offset(查询起始偏移量)、limit(每页查询记录数)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/activity/deleteNewsSpecialActivity<br/>
   	删除新闻的特定标签<br/>
   	参数：newsIDs(新闻ID,CheckBox的id值)、activityID(专题标签ID)
   	<hr/>
   	
   	
   	<h1>网站前端接口</h1>
   	http://20.14.3.21:8080/committeewb/weather<br/>
   	首页天气接口
   	<hr/>
   	http://20.14.3.21:8080/committeewb/index<br/>
   	网站前端首页
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/newsList<br/>
   	新闻列表<br/>
   	参数：currentPage（当前页，从1开始）、newsTypeID（新闻类型ID）、activityID（专题标签id）
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/{activityID}/{newsTypeID}/{id}/query(Restful风格)<br/>
   	查询新闻，同时新闻访问量+1  <br/>
   	参数：id(新闻id)、newsTypeID(新闻类型ID)、activityID(专题标签ID，不限制标签类型时传-1)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/home/1/query(Restful风格)<br/>
   	查询规章制度、工作标准、通讯录、风采录  （查询规章制度）<br/>
   	参数：id(规章制度-->风采录，依次为1、2、3、4)
   	<hr/>
   	http://20.14.3.21:8080/committeewb/news/isHotNews/{id}/{isHotNews}
   	改变新闻 是否是 热门新闻 这一状态
   	参数：id(新闻id)、isHotNews(是否是热门新闻，0:是,1:否，默认0)
   	<hr/>
   	
  </body>
</html>
