<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><c:if test="${type!=null}">${type}</c:if><c:if test="${type==null}">编辑</c:if></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		
		<link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/media/css/write.css"/>
  </head>
  
  <body>
  	<%
		Object user = request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect("/committeewb/admin/login.jsp");
		}
	 %>
    <div class="header">
			<span id="articleId" style="display: none;"><c:if test="${id!=null }">${id }</c:if><c:if test="${id==null }">-1</c:if></span>
			<div class="logo">
				蜀南气矿
			</div>
			<div class="title-wrapper">
				<span class="title"><c:if test="${type!=null}">${type}</c:if><c:if test="${type==null}">编辑</c:if></span>
				<span class="titleinfo titlegray">修改自动保存</span>
			</div>
		</div>
		
		<div class="edit-wrapper">
			<div class="writeTitle-wrapper">
				<textarea id="textarea" rows="1" class="Input" placeholder="请输入标题" style="height: 44px; border: 1px solid #EEEEEE;"></textarea>
			</div>
			<div class="writeContent-wrapper">
				<script type="text/plain" id="editor" style="width:100%; height: 500px;">
				</script>
			</div>
		</div>
		<!--<script src="media/js/jquery-1.10.1.min.js"></script>-->
 	    <script src="${pageContext.request.contextPath }/admin/media/js/third-party/jquery.min.js"></script>
    	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/ueditor.config.js"></script>
	    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/ueditor.all.js"> </script>
	    <!--<script type="text/javascript" charset="utf-8" src="ueditor.parse.js"> </script>-->
	    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/lang/zh-cn/zh-cn.js"></script>
	    <script type="text/javascript" charset="UTF-8" src="${pageContext.request.contextPath }/admin/media/laydate.js"></script>
   		<script src="${pageContext.request.contextPath }/admin/media/src/commonUtils.js"></script>
   		<script src="${pageContext.request.contextPath }/admin/media/src/homeWrite.js"></script>
  		<!-- 实例化编辑器 -->
    	<script type="text/javascript">
    		HomeWrite.init();
			</script>
  </body>
</html>
