<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>写文章</title>
		<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
		<meta content="" name="description"/>
	    <meta content="" name="author"/>
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
				蜀南气矿团委
			</div>
			<div class="title-wrapper">
				<span class="title">写文章</span>
				<span class="titleinfo titlegray">草稿自动保存</span>
			</div>
			<div class="publish-wapper" >
				<button disabled="true" type="button" class="btn publish-btn publish-no">发布<i class="icon-chevron-down"></i></button>
				<div class="box">
					<div class="arrow-group">
						<span class="pannel-arrow "></span>
						<span class="pannel-arrow1"></span>
					</div>
						
					<div class="publish-pannel">
						<label id="isPicNewsLable" class="" for="isPicNews">
							<input class="picNews-no" id="isPicNews" type="checkbox" />   是否作为图片新闻展示
						</label>
						<div class="showtime">
							<span>显示时间:</span>
							<input id="datatimeid" placeholder="yyyy-MM-dd HH:mm:ss" class="layui-input" type="text" style="height: 22px;width: 138px;" readonly="readonly">
						</div>
						
						<div class="nextbtn-wrapper">
							<button class="nextbtn">确定</button>
						</div>
					</div>
						
				</div>
			</div>
			
		</div>
		
		<div class="edit-wrapper">
			<div class="newsType-wrapper">
				<b>新闻类型:</b><br>
				<div class="label-wrapper label-radio">
					<label for="newstype1">
						<input id="newstype1" name="newstype" type="radio" value="1" checked/>重点关注 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype2">
						<input id="newstype2" name="newstype" type="radio" value="2" />公告栏 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype3">
						<input id="newstype3" name="newstype" type="radio" value="3" />文件通知 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype4">
						<input id="newstype4" name="newstype" type="radio" value="4" />团情快讯 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype5">
						<input id="newstype5" name="newstype" type="radio" value="5" />蜀南青语 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label style="display: none;" for="newstype6">
						<input id="newstype6" name="newstype" type="radio" value="6" />专题活动 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype7">
						<input id="newstype7" name="newstype" type="radio" value="7" />青春剪影 <span style="color: #EEEEEE;">|</span> 
					</label>
					<label for="newstype8">
						<input id="newstype8" name="newstype" type="radio" value="8" />生活大家谈 
					</label>
				</div>
			</div>
			<div class="special-wrapper">
				<b>专题标签:</b><br>
				<div class="label-wrapper label-checkbox">
				</div>
			</div>
			<div class="writeCover-wrapper">
				<div class="noticeInfo">图片像素宽高比要求4:3</div>
				<div class="writeCover-previewWrapper">
					<i class="writeCover-uploadIcon icon-picture"></i>
					<form id="tiTuFileInput" enctype='multipart/form-data'>
						<input id="inputid" type="file" class="writeCover-uploadInput" name="picFile" accept=".jpeg,.jpg,.png">
					</form>
					<div class="addtext">添加题图</div>
					<div id="progress-wrapper" class="progress-wrapper">
						<div id="progressbar">
					        <!--用来模仿进度条推进效果的进度条元素-->
					        <div id="fill"></div>
					    </div>
					</div>
				</div>
				<div class="img-wrapper">
					<img id="tiTuImg" src="" style="width: 100%; display: block;"/>
					<div class="reset-delete-wrapper"> 
						<div class="rede reset">
							<form  id="resettiTuFileInput" enctype='multipart/form-data'>
								<input id="resetInputid" title="替换" type="file" class="reset-uploadInput" name="picFile" accept=".jpeg,.jpg,.png">
							</form>
							<i class="icon-picture"></i>替换</div>
						<div class="rede remove" title="删除"><i class="icon-remove"></i>删除</div>
					</div>
				</div>
				
			</div>
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
   		<script src="${pageContext.request.contextPath }/admin/media/src/progress.js"></script>
   		<script src="${pageContext.request.contextPath }/admin/media/src/write.js?version=1.0"></script>
    	<!-- 实例化编辑器 -->
    	<script type="text/javascript">
    		Write.init();
		</script>
	</body>
</html>
