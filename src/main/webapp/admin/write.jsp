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
	    <!--<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	    <link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>-->
	    <link href="${pageContext.request.contextPath }/admin/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/media/css/write.css"/>
	</head>
	<body>
		<div class="header">
			<div class="logo">
				翡翠
			</div>
			<div class="title-wrapper">
				<span class="title">写文章</span>
				<span class="titleinfo">草稿自动保存</span>
			</div>
			<div class="publish-wapper">
				<span class="btn my-btn">发布<i class="icon-chevron-down"></i></span>
				<span class="dropmenu">。。。</span>
			</div>
		</div>
		<div class="edit-wrapper">
			<div class="writeCover-wrapper">
				<div class="writeCover-previewWrapper">
					<i class="writeCover-uploadIcon icon-picture"></i>
					<input title="添加题图" type="file" class="writeCover-uploadInput" name="upload_file" accept=".jpeg,.jpg,.png">
				</div>
			</div>
			<div class="writeTitle-wrapper">
				<textarea id="textarea" rows="1" class="Input" placeholder="请输入标题" style="height: 44px;"></textarea>
			</div>
			<div class="writeContent-wrapper">
				<script type="text/plain" id="editor" style="width:100%; height: 500px;">
				</script>
			</div>
		</div>
 	    <script src="${pageContext.request.contextPath }/admin/media/js/jquery-1.10.1.min.js"></script>
    	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/ueditor.config.js"></script>
	    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/ueditor.all.js"> </script>
	    <!--<script type="text/javascript" charset="utf-8" src="ueditor.parse.js"> </script>-->
	    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/admin/media/js/lang/zh-cn/zh-cn.js"></script>
   		<script src="${pageContext.request.contextPath }/admin/media/src/write.js"></script>
   	
    	<!-- 实例化编辑器 -->
    	<script type="text/javascript">
    		Write.init();
	    </script>
	</body>
</html>
